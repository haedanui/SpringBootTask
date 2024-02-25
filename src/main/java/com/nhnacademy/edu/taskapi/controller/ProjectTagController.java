package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.ResultResponse;
import com.nhnacademy.edu.taskapi.domain.projecttag.ProjectTagCreateDto;
import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectTag;
import com.nhnacademy.edu.taskapi.service.ProjectTagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectTagController {

    private final ProjectTagService projectTagService;

    public ProjectTagController(ProjectTagService projectTagService) {
        this.projectTagService = projectTagService;
    }

    @GetMapping("/projects/{projectId}/task/{taskNumber}/tags")
    public List<TagNameDto> getTagNamesByTaskNumber(@PathVariable Long taskNumber) {
        return projectTagService.getTagNamesByTaskNumber(taskNumber);
    }

    @PostMapping("/projects/{projectId}/task/{taskNumber}/tags")
    public ProjectTag createProjectTag(@PathVariable Long taskNumber, @RequestBody ProjectTagCreateDto projectTagCreateDto){
        return projectTagService.createProjectTag(taskNumber, projectTagCreateDto);
    }

    @DeleteMapping("/projects/{projectId}/task/{taskNumber}/tags/{tagNumber}")
    public ResultResponse deleteProjectTag(@PathVariable Long taskNumber, @PathVariable Long tagNumber){
        projectTagService.deleteProjectTag(tagNumber, taskNumber);
        return new ResultResponse("ProjectTag 삭제 완료!");
    }
}
