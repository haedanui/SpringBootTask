package com.nhnacademy.edu.taskapi.domain.project;

//Project 멤버는 자신이 속한 Project 목록만 확인할 수 있습니다.q
public interface ProjectInfoDto {
    Long getProjectId();
    String getProjectName();
    String getProjectState();
    String getProjectAdmin();
}
