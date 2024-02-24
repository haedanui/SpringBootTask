package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.Tag;
import com.nhnacademy.edu.taskapi.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<TagNameDto> getTags(){
        return tagService.getTags();
    }

//    @GetMapping("/{projectId}")
//    public List<TagNameDto> getTags(@PathVariable("projectId") Long projectId){
//        return tagService.getTags(projectId);
//    }
}
