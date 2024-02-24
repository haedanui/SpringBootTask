package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT new com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto(pm.project.projectId, pm.project.projectName, pm.project.projectState, pm.project.projectAdmin) FROM ProjectMember pm WHERE pm.userName = :userName")
    List<ProjectInfoDto> findProjectsByMemberUserName(String userName);

    // 모든 프로젝트 정보를 조회합니다.
    @Query("SELECT new com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto(pm.project.projectId, pm.project.projectName, pm.project.projectState, pm.project.projectAdmin) FROM ProjectMember pm")
    List<ProjectInfoDto> findProjectsByMember();

    Project findByProjectName(String projectName);

}
