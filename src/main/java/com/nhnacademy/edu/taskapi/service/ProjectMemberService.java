package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.projectmember.ProjectMemberCreateDto;
import com.nhnacademy.edu.taskapi.domain.projectmember.userNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    List<userNameDto> getProjectMembers(Long projectId);

    ProjectMember createProjectMember(ProjectMemberCreateDto projectMemberCreateDto);

    void deleteProjectMember(Long userNumber);

}
