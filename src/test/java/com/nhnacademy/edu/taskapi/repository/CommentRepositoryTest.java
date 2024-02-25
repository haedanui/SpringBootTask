package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Comment;
import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.Task;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void getAndCreateCommentTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        Task task = new Task(1L, "진행중", "과제1", "이거슨 과제1이여", project);

        entityManager.merge(project);
        entityManager.merge(task);

        Comment comment = new Comment(1L, "이거슨 내용이여", "유승진");

        commentRepository.save(comment);

        Comment checkComment = commentRepository.findById(1L).orElse(null);

        assertThat(checkComment).isNotNull();
        assertThat(checkComment.getCommentContent()).isEqualTo("이거슨 내용이여");

    }

    @Test
    void deleteCommentTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        Task task = new Task(1L, "진행중", "과제1", "이거슨 과제1이여", project);

        entityManager.merge(project);
        entityManager.merge(task);

        Comment comment = new Comment(1L, "이거슨 내용이여", "유승진");
        commentRepository.save(comment);
        comment = new Comment(2L, "이것도 내용이여", "유승진");
        commentRepository.save(comment);
        List<Comment> comments = commentRepository.findAll();
        assertThat(comments.size()).isEqualTo(2);

        commentRepository.deleteById(1L);

        comments = commentRepository.findAll();

        assertThat(comments.size()).isEqualTo(1);


    }
}