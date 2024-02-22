package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.entity.Tag;
import com.nhnacademy.edu.taskapi.repository.MilestoneRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectMemberRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;
import com.nhnacademy.edu.taskapi.repository.TagRepository;
import com.nhnacademy.edu.taskapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    //프로젝트를 생성합니다.
    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    //TODO checkpoint 프로젝트의 status 코드를 바꿉니다. 생성 코드랑 같으나 구분을 위해 적었고 컨트롤러단에서 status를 set 하고 서비스를 불러와 주세요 까먹지 말고!!!!
    @Override
    public Project updateStatusProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }


}
