package com.nhnacademy.edu.taskapi.domain.task;

import lombok.*;

@Data
@AllArgsConstructor
public class TaskCreateDto {
    private String taskTitle;
    private String taskContent;
}
