package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.projectmember.UserNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {

    List<UserNameDto> findAllByProjectNumber(Long projectId);

}
