package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.domain.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.entity.Project;

import java.util.List;

public interface ProjectService {
    List<NameIncludeProjectDto> getProjects();

    List<NameIncludeProjectDto> getProjectsIncludeName(String userName);

    Project getProject(Long projectId);

    Project createProject(ProjectCreateDto projectCreateDto);

    Project updateStatusProject(Project project);

    void deleteProject(Long projectId);

}
