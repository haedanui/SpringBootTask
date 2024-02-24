package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.project.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto;
//import com.nhnacademy.edu.taskapi.domain.project.ProjectResponseDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

//    @Query("select new com.nhnacademy.edu.taskapi.domain.project.ProjectResponseDto(p.projectId,p.projectName,p.projectState,p.projectAdmin) " +
//            "from Project p " +
//            "where p.projectId = ?1")
//    ProjectResponseDto findByProjectId(Long projectId);
//    @Query("SELECT p FROM Project p JOIN p.projectMembers pm WHERE pm.userName = :userName")
//    List<NameIncludeProjectDto> findProjectsByMemberUserName(String userName);
//
//    @Query("SELECT p FROM Project p JOIN p.projectMembers pm")
//    List<NameIncludeProjectDto> findProjectsByMember();

//    @Query("UPDATE Project p SET p.projectState = :projectState WHERE p.projectId = :projectId")
//    int updateProjectState(@Param("projectId") Long projectId, @Param("projectState") String projectState);
//
//
    //중복유무
    boolean existsProjectByProjectId(Long projectId);

    ProjectInfoDto findByProjectId(Long projectId);

    @Query("SELECT new com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto(pm.project.projectId, pm.project.projectName, pm.project.projectState, pm.project.projectAdmin) FROM ProjectMember pm WHERE pm.userName = :userName")
    List<ProjectInfoDto> findProjectsByMemberUserName(String userName);

    // 모든 프로젝트 정보를 조회합니다.
    @Query("SELECT new com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto(pm.project.projectId, pm.project.projectName, pm.project.projectState, pm.project.projectAdmin) FROM ProjectMember pm")
    List<ProjectInfoDto> findProjectsByMember();

    Project findByProjectName(String projectName);



}
