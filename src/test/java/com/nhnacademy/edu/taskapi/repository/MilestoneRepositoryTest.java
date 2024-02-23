package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MilestoneRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Test
    void getAndCreateMilestoneTest() {
        Project project = new Project(1L, "프로젝트1","진행중", "유승진");
        entityManager.persist(project);
        Milestone milestone = new Milestone(1L, LocalDate.now(), LocalDate.now(), project);

        milestoneRepository.save(milestone);

        Milestone checkMilestone = milestoneRepository.findById(1L).orElse(null);

        assertThat(checkMilestone).isNotNull();
        assertThat(checkMilestone.getDateStart()).isEqualTo(LocalDate.now());
    }

    @Test
    void deleteMilestoneTest(){
        Project project = new Project(1L, "프로젝트1","진행중", "유승진");
        entityManager.persist(project);

        Milestone milestone = new Milestone(1L, LocalDate.now(), LocalDate.now(), project);
        milestoneRepository.save(milestone);

        milestone = new Milestone(2L, LocalDate.now(), LocalDate.now(), project);
        milestoneRepository.save(milestone);

        List<Milestone> milestones = milestoneRepository.findAll();



        milestoneRepository.deleteById(1L);

        milestones = milestoneRepository.findAll();

        assertThat(milestones.size()).isEqualTo(1);


    }
}