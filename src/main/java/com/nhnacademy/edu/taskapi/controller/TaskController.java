package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.ResultResponse;
import com.nhnacademy.edu.taskapi.domain.task.TaskCreateDto;
import com.nhnacademy.edu.taskapi.domain.task.TaskResponseDto;
import com.nhnacademy.edu.taskapi.domain.task.TaskUpdateDto;
import com.nhnacademy.edu.taskapi.entity.Task;
import com.nhnacademy.edu.taskapi.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/projects/{projectId}/task")
    public List<TaskResponseDto> getTasks(@PathVariable("projectId") Long projectId) {
        return taskService.getTasks(projectId);
    }

    @GetMapping("/projects/{projectId}/task/{taskNumber}")
    public TaskResponseDto getTask(@PathVariable("projectId") Long projectId, @PathVariable("taskNumber") Long taskNumber) {
        return taskService.getTask(projectId, taskNumber);
    }

    @PostMapping("/projects/{projectId}/task")
    public Task createTask(@PathVariable("projectId") Long projectId, @RequestBody TaskCreateDto taskCreateDto) {
        return taskService.createTask(projectId, taskCreateDto);
    }

    @PutMapping("/projects/{projectId}/task/{taskNumber}")
    public Task updateTask(@PathVariable("projectId") Long projectId, @PathVariable("taskNumber") Long taskNumber, @RequestBody TaskUpdateDto taskUpdateDto) {
        return taskService.updateTask(projectId, taskNumber, taskUpdateDto);
    }
    @DeleteMapping("/projects/{projectId}/task/{taskNumber}")
    public ResultResponse deleteTask(@PathVariable("projectId") Long projectId, @PathVariable("taskNumber") Long taskNumber) {
        taskService.deleteTask(projectId, taskNumber);
        return new ResultResponse("task 삭제 완료!");
    }
}
