package com.nhnacademy.edu.taskapi.repository;

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
@Disabled
class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void getAndCreateTaskTest() {
        Project project = new Project(1L, "프로젝트1", "진행중", "유승진");
        entityManager.merge(project);

        Task task = new Task(1L, "진행중", "과제1", "과제1번입니다.", project);
        taskRepository.save(task);

        Task checkTask = taskRepository.findById(1L).orElse(null);

        assertThat(checkTask.getTaskTitle()).isEqualTo("과제1");
        assertThat(checkTask.getTaskState()).isEqualTo("진행중");
    }
}