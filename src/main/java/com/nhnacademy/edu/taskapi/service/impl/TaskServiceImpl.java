package com.nhnacademy.edu.taskapi.service.impl;

//import com.nhnacademy.edu.taskapi.domain.project.ProjectResponseDto;
import com.nhnacademy.edu.taskapi.domain.task.TaskCreateDto;
import com.nhnacademy.edu.taskapi.domain.task.TaskUpdateDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.Task;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;
import com.nhnacademy.edu.taskapi.repository.TaskRepository;
import com.nhnacademy.edu.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<Task> getTasks(Long projectId) {
        return taskRepository.findTaskByProject_ProjectId(projectId);
    }

    @Override
    public Task getTask(Long projectId, Long taskNumber) {
        return taskRepository.findTaskByProject_ProjectIdAndTaskNumber(projectId, taskNumber);
    }

    @Override
    public Task createTask(Long projectId, TaskCreateDto taskCreateDto) {

        Project project = projectRepository.findById(projectId).orElse(null);

            Task task = new Task();
            task.setTaskTitle(taskCreateDto.getTaskTitle());
            task.setTaskContent(taskCreateDto.getTaskContent());
            task.setTaskState("할 일"); // 할 일, 진행중, 완료 중 default로 할 일로 설정
            task.setProject(project);
            return taskRepository.save(task);
        }

    @Override
    public Task updateTask(Long projectId, Long taskNumber, TaskUpdateDto taskUpdateDto) {
        Task task = taskRepository.findById(taskNumber).orElse(null);

        task.setTaskTitle(taskUpdateDto.getTaskTitle());
        task.setTaskContent(taskUpdateDto.getTaskContent());
        task.setTaskState(taskUpdateDto.getTaskState());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long projectId, Long taskNumber) {
        taskRepository.deleteById(taskNumber);
    }
}
