package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.entity.Tag;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    Project updateStatusProject(Project project);

    void deleteProject(Long projectId);

}
