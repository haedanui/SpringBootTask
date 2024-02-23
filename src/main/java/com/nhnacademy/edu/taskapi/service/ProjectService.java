package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.project.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.entity.Project;

import java.util.List;

public interface ProjectService {
    List<NameIncludeProjectDto> getProjects();

    List<NameIncludeProjectDto> getProjectsIncludeName(String userName);

    Project getProject(Long projectId);

    Project createProject(ProjectCreateDto projectCreateDto);

    Project updateStatusProject(Long projectId, String state);

    void deleteProject(Long projectId);

}
