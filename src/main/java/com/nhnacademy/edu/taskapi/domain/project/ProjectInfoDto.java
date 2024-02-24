package com.nhnacademy.edu.taskapi.domain.project;

//Project 멤버는 자신이 속한 Project 목록만 확인할 수 있습니다.

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectInfoDto {
    Long projectId;
    String projectName;
    String projectState;
    String projectAdmin;

    public ProjectInfoDto(Long projectId, String projectName, String projectState, String projectAdmin) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectState = projectState;
        this.projectAdmin = projectAdmin;
    }

}
