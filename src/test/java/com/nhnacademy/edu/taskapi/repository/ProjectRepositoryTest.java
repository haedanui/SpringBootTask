package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Project;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void test1() {
        Project project1 = new Project();
//        project1.setProjectId(1L);
//        project1.setProjectName("프로젝트1");
//        project1.setProjectState("진행중");
//        project1.setProjectAdmin("유승진");
//        this.entityManager.persist(project1);
//        Project project = projectRepository.findById(1L).orElse(null);
//        assertThat(project.getProjectName()).isEqualTo("프로젝트1");
//        assertThat(project.getProjectAdmin()).isEqualTo("유승진");
    }

}