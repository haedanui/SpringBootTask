package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.projecttag.ProjectTagCreateDto;
import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectTag;
import com.nhnacademy.edu.taskapi.entity.Tag;
import com.nhnacademy.edu.taskapi.entity.Task;
import com.nhnacademy.edu.taskapi.repository.ProjectTagRepository;
import com.nhnacademy.edu.taskapi.repository.TagRepository;
import com.nhnacademy.edu.taskapi.repository.TaskRepository;
import com.nhnacademy.edu.taskapi.service.ProjectTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTagServiceImpl implements ProjectTagService {

    ProjectTagRepository projectTagRepository;
    TaskRepository taskRepository;
    TagRepository tagRepository;

    @Autowired
    public ProjectTagServiceImpl(ProjectTagRepository projectTagRepository, TaskRepository taskRepository, TagRepository tagRepository) {
        this.projectTagRepository = projectTagRepository;
        this.taskRepository = taskRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagNameDto> getTagNamesByTaskNumber(Long taskNumber) {
        return projectTagRepository.findTagNamesByTaskNumber(taskNumber);
    }

    @Override
    public List<ProjectTag> getProjectTags() {
        return projectTagRepository.findAll();
    }

    @Override
    public ProjectTag getProjectTag(Long tagNumber, Long taskNumber) {
        ProjectTag.PK pk = new ProjectTag.PK(tagNumber, taskNumber);
        return projectTagRepository.findById(pk).orElse(null);

    }

    @Override
    public ProjectTag createProjectTag(Long taskNumber, ProjectTagCreateDto projectTagCreateDto) {
        ProjectTag.PK pk = new ProjectTag.PK();
        pk.setTaskNumber(taskNumber);
        pk.setTagNumber(projectTagCreateDto.getTagNumber());

        Task task = taskRepository.findById(taskNumber).orElse(null);
        Tag tag = tagRepository.findById(projectTagCreateDto.getTagNumber()).orElse(null);

        ProjectTag projectTag = new ProjectTag();
        projectTag.setPk(pk);
        projectTag.setTask(task);
        projectTag.setTag(tag);
        return projectTagRepository.save(projectTag);
    }

    @Override
    public void deleteProjectTag(Long tagNumber, Long taskNumber) {
        ProjectTag.PK pk = new ProjectTag.PK(tagNumber, taskNumber);
        projectTagRepository.deleteById(pk);
    }
}
