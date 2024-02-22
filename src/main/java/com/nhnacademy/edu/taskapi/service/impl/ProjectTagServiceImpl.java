package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.entity.ProjectTag;
import com.nhnacademy.edu.taskapi.repository.ProjectTagRepository;
import com.nhnacademy.edu.taskapi.service.ProjectTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTagServiceImpl implements ProjectTagService {

    ProjectTagRepository projectTagRepository;

    @Autowired
    public ProjectTagServiceImpl(ProjectTagRepository projectTagRepository) {
        this.projectTagRepository = projectTagRepository;
    }

    @Override
    public List<ProjectTag> getProjectTags() {
        return projectTagRepository.findAll();
    }

    @Override
    public ProjectTag addProjectTag(ProjectTag projectTag) {
        return projectTagRepository.save(projectTag);
    }

    @Override
    public void deleteProjectTag(Long tagNumber, Long taskNumber) {
        ProjectTag.PK pk = new ProjectTag.PK(tagNumber, taskNumber);
        projectTagRepository.deleteById(pk);
    }
}
