package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.tag.TagCreateDto;
import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.Tag;

import java.util.List;

public interface TagService {

    List<TagNameDto> getTags();

    List<TagNameDto>getProjectTags(Long projectId);

    Tag getTag(Long tagNumber);

    Tag createTag(TagCreateDto tagCreateDto, Long projectId);

    void deleteTag(Long tagNumber);
}
