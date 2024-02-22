package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getProjects();

    Project getProject(Long id);

    Project createProject(Project project);
}
