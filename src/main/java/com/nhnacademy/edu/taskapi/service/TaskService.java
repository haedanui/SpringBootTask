package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.task.TaskCreateDto;
import com.nhnacademy.edu.taskapi.domain.task.TaskResponseDto;
import com.nhnacademy.edu.taskapi.domain.task.TaskUpdateDto;
import com.nhnacademy.edu.taskapi.entity.Task;

import java.util.List;

public interface TaskService {

    List<TaskResponseDto> getTasks(Long projectId);

    TaskResponseDto getTask(Long projectId, Long taskNumber);

    Task createTask(Long projectId, TaskCreateDto taskCreateDto);

    Task updateTask(Long projectId, Long taskNumber, TaskUpdateDto taskUpdateDto);

    void deleteTask(Long projectId, Long taskNumber);
}
