package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Slf4j
class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void getProjectTest() {
        Project project = new Project(1L, "프로젱트1", "진행중", "유승진");
        ProjectMember projectMember = new ProjectMember(1L, "유승진", 1L, project);

        projectRepository.save(project);

        Project checkProject = projectRepository.findById(1L).orElse(null);


        assertThat(checkProject).isNotNull();
        assertThat(project.getProjectName()).isEqualTo("프로젱트1");
        assertThat(project.getProjectAdmin()).isEqualTo("유승진");


    }


    @Test
    void getProjectsAndSaveTest() {
        Project project1 = new Project(1L, "프로젝트1","진행중", "유승진");
        projectRepository.save(project1);
        List<Project> projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(1);

        Project project2 = new Project(2L, "프로젝트2", "완료", "페이커");
        projectRepository.save(project2);
        projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(1);
    }

    @Test
    void updateStateTest() {
        Project project1 = new Project(1L, "프로젝트1","진행중", "유승진");
        projectRepository.save(project1);
        assertThat(project1.getProjectState()).isEqualTo("진행중");

        project1.setProjectState("완료");
        projectRepository.save(project1);
        assertThat(project1.getProjectState()).isEqualTo("완료");
    }

    @Test
    void deleteProjectTest(){
        Project project2 = new Project(2L, "프로젝트2", "완료", "페이커");
        projectRepository.save(project2);
        List<Project>projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(1);

        projectRepository.deleteById(1L);
        projects = projectRepository.findAll();
        assertThat(projects.size()).isEqualTo(1);
        assertThat(projects.get(0).getProjectAdmin()).isEqualTo("페이커");
    }
}