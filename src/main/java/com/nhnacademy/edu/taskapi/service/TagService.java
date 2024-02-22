package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.Tag;

import java.util.List;

public interface TagService {



    List<Tag> getTags();

    Tag getTag(Long tagNumber);

    Tag addTag(Tag tag);

    void delete(Long tagNumber);
}
