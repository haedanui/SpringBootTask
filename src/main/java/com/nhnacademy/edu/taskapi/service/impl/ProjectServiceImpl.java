package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.domain.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.exception.ProjectAlreadyExistsException;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;
import com.nhnacademy.edu.taskapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    public List<NameIncludeProjectDto> getProjects(){
        return projectRepository.findProjectsByMember();
    }

    @Override
    public List<NameIncludeProjectDto> getProjectsIncludeName(String userName) {
        return projectRepository.findProjectsByMemberUserName(userName);
    }


    @Override
    public Project getProject(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    //프로젝트를 생성합니다.
    @Override
    public Project createProject(ProjectCreateDto projectCreateDto) {
        if(projectRepository.existsProjectByProjectId(projectCreateDto.getProjectId())){
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

    //TODO checkpoint 프로젝트의 status 코드를 바꿉니다. 생성 코드랑 같으나 구분을 위해 적었고 컨트롤러단에서 status를 set 하고 서비스를 불러와 주세요 까먹지 말고!!!!
    @Override
    public Project updateStatusProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
