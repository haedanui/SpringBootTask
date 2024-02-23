package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.project.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p JOIN p.projectMembers pm WHERE pm.userName = :userName")
    List<NameIncludeProjectDto> findProjectsByMemberUserName(String userName);

    @Query("SELECT p FROM Project p JOIN p.projectMembers pm")
    List<NameIncludeProjectDto> findProjectsByMember();

    @Query("UPDATE Project p SET p.projectState = :projectState WHERE p.projectId = :projectId")
    int updateProjectState(@Param("projectId") Long projectId, @Param("projectState") String projectState);


    //중복유무
    boolean existsProjectByProjectId(Long projectId);
}
