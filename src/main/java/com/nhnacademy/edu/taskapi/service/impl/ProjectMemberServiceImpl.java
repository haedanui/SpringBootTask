package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.projectmember.ProjectMemberCreateDto;
import com.nhnacademy.edu.taskapi.domain.projectmember.userNameDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;

    @Autowired
    public ProjectMemberServiceImpl(ProjectMemberRepository projectMemberRepository) {
        this.projectMemberRepository = projectMemberRepository;
    }

    @Override
    public List<userNameDto> getProjectMembers(Long projectId) {
//        return this.projectMemberRepository.findByPkProjectId(projectId);
        return null;
    }

    @Override
    @Transactional
    public ProjectMember createProjectMember(ProjectMemberCreateDto projectMemberCreateDto) {
        Project project = new Project();
        project.setProjectId(projectMemberCreateDto.getProjectId());

        ProjectMember projectMember = new ProjectMember();
        projectMember.setUserNumber(projectMemberCreateDto.getUserNumber());
        projectMember.setUserName(projectMemberCreateDto.getUserName());


//        ProjectMember projectMember = new ProjectMember();
//        ProjectMember.PK pk = new ProjectMember.PK();
//        pk.setProjectId(projectMemberCreateDto.getProjectId());
//        pk.setUserNumber(projectMemberCreateDto.getUserNumber());
//        projectMember.setPk(pk);
//        projectMember.setUserName(projectMemberCreateDto.getUserName());
//        projectMember.setProject(project);

        projectMemberRepository.save(projectMember);
        return projectMember;
    }

    @Override
    @Transactional
    public void deleteProjectMember(Long userNumber) {
        projectMemberRepository.deleteById(userNumber);
    }
}
