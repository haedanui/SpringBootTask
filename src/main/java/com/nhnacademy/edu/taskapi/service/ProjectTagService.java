package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.ProjectTag;

import java.util.List;

public interface ProjectTagService {

    List<ProjectTag> getProjectTags();

    ProjectTag getProjectTag(Long tagNumber, Long taskNumber);

    ProjectTag createProjectTag(ProjectTag projectTag);

    void deleteProjectTag(Long tagNumber, Long taskNumber);
}
