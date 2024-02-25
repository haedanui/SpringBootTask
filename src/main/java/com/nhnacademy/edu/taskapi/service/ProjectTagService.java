package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.projecttag.ProjectTagCreateDto;
import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectTag;

import java.util.List;

public interface ProjectTagService {

    List<ProjectTag> getProjectTags();

    List<TagNameDto> getTagNamesByTaskNumber(Long taskNumber);

    ProjectTag getProjectTag(Long tagNumber, Long taskNumber);

    ProjectTag createProjectTag(Long taskNumber, ProjectTagCreateDto projectTagCreateDto);

    void deleteProjectTag(Long tagNumber, Long taskNumber);
}
