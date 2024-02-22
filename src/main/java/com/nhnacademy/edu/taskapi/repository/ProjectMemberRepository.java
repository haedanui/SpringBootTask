package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
}
