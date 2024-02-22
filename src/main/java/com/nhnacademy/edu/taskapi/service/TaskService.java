package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTask(Long taskNumber);

    Task createTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Long taskNumber);
}
