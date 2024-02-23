package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.Task;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void getAndCreateTaskTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        Milestone milestone = new Milestone(1L, LocalDate.now(), LocalDate.now());
        entityManager.persist(project);
        entityManager.persist(milestone);

        Task task = new Task(1L, "진행중", "과제1", "과제1번입니다.", milestone, project);
        taskRepository.save(task);

        Task checkTask = taskRepository.findById(1L).orElse(null);

        assertThat(checkTask.getTaskTitle()).isEqualTo("과제1");
        assertThat(checkTask.getTaskState()).isEqualTo("진행중");
    }

    @Test
    void deleteTaskTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        Milestone milestone = new Milestone(1L, LocalDate.now(), LocalDate.now());
        entityManager.persist(project);
        entityManager.persist(milestone);

        Task task = new Task(1L, "진행중", "과제1", "과제1번입니다.", milestone, project);
        taskRepository.save(task);

        task = new Task(2L, "완료", "과제2", "과제2번입니다.", milestone, project);
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks.size()).isEqualTo(2);

        taskRepository.deleteById(1L);
        tasks = taskRepository.findAll();
        assertThat(tasks.size()).isEqualTo(1);
    }
}