package com.nhnacademy.edu.taskapi.domain.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDto {
    private String taskTitle;
    private String taskContent;
    private String taskState;
}
