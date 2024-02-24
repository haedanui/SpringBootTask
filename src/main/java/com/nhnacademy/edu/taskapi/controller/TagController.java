package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.ResultResponse;
import com.nhnacademy.edu.taskapi.domain.tag.TagCreateDto;
import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.Tag;
import com.nhnacademy.edu.taskapi.service.TagService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{projectId}")
    public List<TagNameDto> getProjectTags(@PathVariable("projectId")Long projectId){
        return tagService.getProjectTags(projectId);
    }

    @PostMapping("/{projectId}")
    public Tag createTag(@RequestBody TagCreateDto tagCreateDto, @PathVariable("projectId")Long projectId){
        return tagService.createTag(tagCreateDto, projectId);
    }

    @DeleteMapping("/{tagId}")
    public ResultResponse deleteTag(@PathVariable("tagId")Long tagId){
        tagService.deleteTag(tagId);
        return new ResultResponse("태그 삭제가 완료되었습니다.");
    }
}
