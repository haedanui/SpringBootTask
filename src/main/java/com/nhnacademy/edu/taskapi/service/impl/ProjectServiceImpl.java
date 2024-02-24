package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.exception.ProjectNotFoundException;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;
import com.nhnacademy.edu.taskapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMemberRepository projectMemberRepository) {
        this.projectRepository = projectRepository;
        this.projectMemberRepository = projectMemberRepository;
    }


    public List<ProjectInfoDto> getProjects() {
        return projectRepository.findProjectsByMember();
    }

    @Override
    @Transactional
    public List<ProjectInfoDto> getProjectsIncludeName(String userName) {
        return projectRepository.findProjectsByMemberUserName(userName);
    }


    @Override
    @Transactional
    public Project getProject(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    //프로젝트를 생성합니다.
    @Override
    @Transactional
    public Project createProject(ProjectCreateDto projectCreateDto) {
        Project project = new Project();
        project.setProjectName(projectCreateDto.getProjectName());
        project.setProjectAdmin(projectCreateDto.getProjectAdmin());
        project.setProjectState("할 일");

        projectRepository.save(project);

        Project checkProject =projectRepository.findByProjectName(projectCreateDto.getProjectName());
        ProjectMember projectMember = new ProjectMember();
        projectMember.setUserName(projectCreateDto.getProjectAdmin());
        projectMember.setProjectNumber(checkProject.getProjectId());
        projectMember.setProject(checkProject);
        projectMemberRepository.save(projectMember);

        return project;
    }

    @Override
    @Transactional
    public Project updateStatusProject(Long projectId, String state) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project == null) {
            throw new ProjectNotFoundException();
        }
        project.setProjectState(state);
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
