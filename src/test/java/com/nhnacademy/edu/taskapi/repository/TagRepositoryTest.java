package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectTag;
import com.nhnacademy.edu.taskapi.entity.Tag;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TagRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TagRepository tagRepository;

    @Test
    void getAndCreateTagTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        entityManager.persist(project);

        Tag tag = new Tag(1L, "과제", project);
        tagRepository.save(tag);

        Tag checkTag = tagRepository.findById(1L).orElse(null);
        Assertions.assertThat(checkTag.getTagName()).isEqualTo("과제");
    }

    @Test
    void deleteTagTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        entityManager.persist(project);

        Tag tag = new Tag(1L, "과제", project);
        tagRepository.save(tag);

        tag = new Tag(2L, "숙제", project);
        tagRepository.save(tag);

        List<Tag> tags = tagRepository.findAll();
        assertThat(tags.size()).isEqualTo(2);

        tagRepository.deleteById(1L);
        tags = tagRepository.findAll();
        assertThat(tags.size()).isEqualTo(1);
    }
}