package com.nhnacademy.edu.taskapi.domain.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponseDto {
    private String taskTitle;
    private String taskContent;
    private String taskState;
}
