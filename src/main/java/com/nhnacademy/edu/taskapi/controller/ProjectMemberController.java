package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.projectmember.ProjectMemberCreateDto;
import com.nhnacademy.edu.taskapi.domain.projectmember.userNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectMember;
import com.nhnacademy.edu.taskapi.service.ProjectMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectmembers")
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    public ProjectMemberController(ProjectMemberService projectMemberService) {
        this.projectMemberService = projectMemberService;
    }

    @GetMapping("/{projectId}")
    public List<userNameDto> getProjectMembers(@PathVariable("projectId") Long projectId) {
        return projectMemberService.getProjectMembers(projectId);
    }

    @PostMapping
    public ProjectMember createProjectMember(@RequestBody ProjectMemberCreateDto projectMemberCreateDto) {
        return projectMemberService.createProjectMember(projectMemberCreateDto);
    }
}
