package com.nhnacademy.edu.taskapi.domain.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectInfoDto {
    private Long projectId;
    private String projectName;
    private String projectState;
    private String projectAdmin;
}
