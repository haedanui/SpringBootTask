package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;

public interface ProjectMemberService {

    ProjectMember addProjectMember(ProjectMember projectMember);

    void deleteProjectMember(Long userNumber);

}
