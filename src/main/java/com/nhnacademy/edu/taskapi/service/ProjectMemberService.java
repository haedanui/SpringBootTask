package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;

import java.util.List;

public interface ProjectMemberService {

    List<ProjectMember> getProjectMembers();

    ProjectMember createProjectMember(ProjectMember projectMember);

    void deleteProjectMember(Long userNumber);

}
