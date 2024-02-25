package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Disabled
class ProjectTagRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private  ProjectTagRepository projectTagRepository;

    @Test
    void getAndCreateProjectTagTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        Task task = new Task(1L, "진행중", "과제1", "이거슨 과제1이여", project);
        Tag tag = new Tag(1L, "과제", project);
        entityManager.merge(project);
        entityManager.merge(task);
        entityManager.merge(tag);

        ProjectTag.PK pk = new ProjectTag.PK(1L, 1L);
        ProjectTag projectTag = new ProjectTag(pk, tag, task);

        projectTagRepository.save(projectTag);
        ProjectTag checkProjectTag = projectTagRepository.findById(pk).orElse(null);
        assertThat(checkProjectTag.getPk().getTagNumber()).isEqualTo(1L);
    }
}