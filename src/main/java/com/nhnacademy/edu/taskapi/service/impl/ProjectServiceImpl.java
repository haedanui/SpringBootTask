package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.project.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto;
//import com.nhnacademy.edu.taskapi.domain.project.ProjectResponseDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.exception.ProjectAlreadyExistsException;
import com.nhnacademy.edu.taskapi.exception.ProjectNotFoundException;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;
import com.nhnacademy.edu.taskapi.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMemberRepository projectMemberRepository) {
        this.projectRepository = projectRepository;
        this.projectMemberRepository = projectMemberRepository;
    }

    @Override
    public List<ProjectInfoDto> getProjects() {
        return projectRepository.findProjectsByMember();
    }

    @Override
    public ProjectInfoDto getProject(Long projectId) {
        return projectRepository.findByProjectId(projectId);
    }

    @Override
    @Transactional
    public List<ProjectInfoDto> getProjectsIncludeName(String userName) {
        return projectRepository.findProjectsByMemberUserName(userName);
    }

    //프로젝트를 생성합니다.
    @Override
    @Transactional
    public Project createProject(ProjectCreateDto projectCreateDto) {
        if (projectRepository.existsProjectByProjectId(projectCreateDto.getProjectId())) {
            throw new ProjectAlreadyExistsException();
        }
        Project project = new Project();
        project.setProjectId(projectCreateDto.getProjectId());
        project.setProjectName(projectCreateDto.getProjectName());
        project.setProjectAdmin(projectCreateDto.getProjectAdmin());
        project.setProjectState("할 일");

        projectRepository.save(project);

        ProjectMember projectMember = new ProjectMember();
        ProjectMember.PK pk = new ProjectMember.PK();
        pk.setProjectId(projectCreateDto.getProjectId());
        pk.setUserNumber(projectCreateDto.getUserNumber());
        projectMember.setPk(pk);
        projectMember.setUserName(projectCreateDto.getProjectAdmin());
        projectMember.setProject(project);

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


    /*
    @Override
    @Transactional
    public ProjectResponseDto getProject(Long projectId) {
        return projectRepository.findByProjectId(projectId);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
     */

}
