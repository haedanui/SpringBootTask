package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void getProjectTest() {
//        Project project = new Project(1L, "프로젱트1", "진행중", "유승진");
//        ProjectMember.PK pk = new ProjectMember.PK(1L, 1L);
//        ProjectMember projectMember = new ProjectMember(pk, "유승진", project);
//        project.setProjectMembers(List.of(projectMember));
//
//        projectRepository.save(project);
//
//        Project checkProject = projectRepository.findById(1L).orElse(null);

//        순수 값 확인용
//        if(checkProject != null){
//            System.out.println(checkProject.getProjectMembers().get(0).getPk().getProjectId());
//            System.out.println(checkProject.getProjectMembers().get(0).getPk().getUserNumber());
//            System.out.println(checkProject.getProjectMembers().get(0).getUserName());
//        }

//        assertThat(checkProject).isNotNull();
//        assertThat(checkProject.getProjectMembers()).hasSize(1);
//        assertThat(project.getProjectName()).isEqualTo("프로젱트1");
//        assertThat(project.getProjectAdmin()).isEqualTo("유승진");
//        assertThat(checkProject.getProjectMembers().get(0).getUserName()).isEqualTo("유승진");

    }


    @Test
    void getProjectsAndSaveTest() {
        Project project1 = new Project(1L, "프로젝트1","진행중", "유승진");
        projectRepository.save(project1);
        List<Project> projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(1);

        Project project2 = new Project(2L, "프로젝트2", "완료", "페이커");
        projectRepository.save(project2);
        projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(2);
    }

    @Test
    void updateStateTest() {
        Project project1 = new Project(1L, "프로젝트1","진행중", "유승진");
        projectRepository.save(project1);
        assertThat(project1.getProjectState()).isEqualTo("진행중");

        project1.setProjectState("완료");
        projectRepository.save(project1);
        assertThat(project1.getProjectState()).isEqualTo("완료");
    }

    @Test
    void deleteProjectTest(){
        Project project1 = new Project(1L, "프로젝트1","진행중", "유승진");
        Project project2 = new Project(2L, "프로젝트2", "완료", "페이커");
        projectRepository.save(project1);
        projectRepository.save(project2);
        List<Project>projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(2);
        projectRepository.deleteById(1L);
        projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(1);
        assertThat(projects.get(0).getProjectAdmin()).isEqualTo("페이커");
    }
}