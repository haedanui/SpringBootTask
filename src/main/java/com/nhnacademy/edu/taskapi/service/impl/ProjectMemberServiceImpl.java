package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;

    @Autowired
    public ProjectMemberServiceImpl(ProjectMemberRepository projectMemberRepository) {
        this.projectMemberRepository = projectMemberRepository;
    }

    @Override
    public List<ProjectMember> getProjectMembers() {
        return this.projectMemberRepository.findAll();
    }

    @Override
    public ProjectMember createProjectMember(ProjectMember projectMember) {
        return projectMemberRepository.save(projectMember);
    }

    @Override
    public void deleteProjectMember(Long userNumber) {
        projectMemberRepository.deleteById(userNumber);
    }
}
