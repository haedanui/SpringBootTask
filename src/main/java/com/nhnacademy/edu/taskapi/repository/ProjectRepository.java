package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p JOIN p.projectMembers pm WHERE pm.userName = :userName")
    List<NameIncludeProjectDto> findProjectsByMemberUserName(String userName);

    @Query("SELECT p FROM Project p JOIN p.projectMembers pm")
    List<NameIncludeProjectDto> findProjectsByMember();


    //중복유무
    boolean existsProjectByProjectId(Long projectId);
}
