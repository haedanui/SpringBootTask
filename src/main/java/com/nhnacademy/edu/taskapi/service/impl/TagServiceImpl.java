package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectTag;
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
    public List<TagNameDto> getTags() {
        return tagRepository.findBy();
    }

//    @Override
//    public List<TagNameDto> getProjectTags(Long projectId){
//
//    }

    @Override
    public Tag getTag(Long tagNumber) {
        return tagRepository.findById(tagNumber).orElse(null);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void delete(Long tagNumber) {
        tagRepository.deleteById(tagNumber);
    }
}
