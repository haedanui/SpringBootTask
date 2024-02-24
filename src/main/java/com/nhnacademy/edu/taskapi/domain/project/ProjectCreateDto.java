package com.nhnacademy.edu.taskapi.domain.project;

import lombok.*;

@Data
@AllArgsConstructor
public class ProjectCreateDto {
    private Long projectId;
    private Long userNumber;
    private String projectName;
    private String projectAdmin;

}
