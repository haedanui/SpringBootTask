package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Project;
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
class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void getProjectTest() {
        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setProjectName("프로젝트1");
        project1.setProjectState("진행중");
        project1.setProjectAdmin("유승진");
        this.entityManager.persist(project1);
        Project project = projectRepository.findById(1L).orElse(null);
        assertThat(project.getProjectName()).isEqualTo("프로젝트1");
        assertThat(project.getProjectAdmin()).isEqualTo("유승진");
    }

    @Test
    void getProjectsAndSaveTest() {
        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setProjectName("프로젝트1");
        project1.setProjectState("진행중");
        project1.setProjectAdmin("유승진");
        projectRepository.save(project1);
        List<Project> projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(1);

        Project project2 = new Project();
        project2.setProjectId(2L);
        project2.setProjectName("프로젝트2");
        project2.setProjectState("완료");
        project2.setProjectAdmin("페이커");
        projectRepository.save(project2);
        projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(2);
    }

    @Test
    void updateStateTest(){
        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setProjectName("프로젝트1");
        project1.setProjectState("진행중");
        project1.setProjectAdmin("유승진");
        projectRepository.save(project1);
        assertThat(project1.getProjectState()).isEqualTo("진행중");

        project1.setProjectState("완료");
        projectRepository.save(project1);
        assertThat(project1.getProjectState()).isEqualTo("완료");
    }
}