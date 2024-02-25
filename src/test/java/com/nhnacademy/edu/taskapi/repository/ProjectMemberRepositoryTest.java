package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ProjectMemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Test
    void getAndCreateProjectMemberTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        entityManager.merge(project);

        ProjectMember projectMember = new ProjectMember(1L, "유승진", 1L, project);

        projectMemberRepository.save(projectMember);

        ProjectMember checkProjectMember = projectMemberRepository.findById(1L).orElse(null);

        assertThat(checkProjectMember).isNotNull();
        assertThat(checkProjectMember.getUserName()).isEqualTo("유승진");
    }

}