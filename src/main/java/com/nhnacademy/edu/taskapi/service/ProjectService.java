package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.project.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto;
//import com.nhnacademy.edu.taskapi.domain.project.ProjectResponseDto;
import com.nhnacademy.edu.taskapi.entity.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectInfoDto> getProjects();

    ProjectInfoDto getProject(Long projectId);

    List<ProjectInfoDto> getProjectsIncludeName(String userName);

    Project createProject(ProjectCreateDto projectCreateDto);

    Project updateStatusProject(Long projectId, String state);

    void deleteProject(Long projectId);

//    List<Project> getAllProjects();

}
