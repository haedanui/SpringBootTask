package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProjectMemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Test
    void getAndCreateProjectMemberTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        entityManager.persist(project);

        ProjectMember.PK pk = new ProjectMember.PK(1L, 1L);
        ProjectMember projectMember = new ProjectMember(pk, "유승진", project);

        projectMemberRepository.save(projectMember);

        ProjectMember checkProjectMember = projectMemberRepository.findById(pk).orElse(null);

        assertThat(checkProjectMember).isNotNull();
        assertThat(checkProjectMember.getUserName()).isEqualTo("유승진");
    }

    @Test
    void deleteProjectMemberTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        entityManager.persist(project);

        ProjectMember.PK pk = new ProjectMember.PK(1L, 1L);
        ProjectMember projectMember = new ProjectMember(pk, "유승진", project);
        projectMemberRepository.save(projectMember);


        pk = new ProjectMember.PK(2L, 1L);
        projectMember = new ProjectMember(pk, "임찬휘", project);
        projectMemberRepository.save(projectMember);

        List<ProjectMember> projectMembers = projectMemberRepository.findAll();
        assertThat(projectMembers.size()).isEqualTo(2);

        pk = new ProjectMember.PK(1L, 1L);

        projectMemberRepository.deleteById(pk);
        projectMembers = projectMemberRepository.findAll();
        assertThat(projectMembers.size()).isEqualTo(1);
        assertThat(projectMembers.get(0).getUserName()).isEqualTo("임찬휘");
    }


}