package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.entity.Tag;
import com.nhnacademy.edu.taskapi.repository.TagRepository;
import com.nhnacademy.edu.taskapi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTag(Long tagNumber) {
        return tagRepository.findById(tagNumber).orElse(null);
    }

    @Override
    public Tag addTag(Tag tag) {
        return null;
    }

    @Override
    public void delete(Long tagNumber) {

    }
}
