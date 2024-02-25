package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.task.TaskResponseDto;
import com.nhnacademy.edu.taskapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<TaskResponseDto> findTaskByProject_ProjectId(Long projectId); // projectId 로 Task 검색

    TaskResponseDto findTaskByProject_ProjectIdAndTaskNumber(Long projectId, Long taskNumber);
}
