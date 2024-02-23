package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.NameIncludeProjectDto;
import com.nhnacademy.edu.taskapi.domain.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.domain.ResultResponse;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.service.ProjectMemberService;
import com.nhnacademy.edu.taskapi.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;

    public ProjectController(ProjectService projectService, ProjectMemberService projectMemberService) {
        this.projectService = projectService;
        this.projectMemberService = projectMemberService;
    }

    @GetMapping
    public List<NameIncludeProjectDto> getProjects(){
        return projectService.getProjects();
    }

    //TODO (Project 멤버는 자신이 속한 Project 목록만 확인할 수 있습니다.)부분
    @GetMapping("/{userName}")
    public List<NameIncludeProjectDto> getProjectsIncludeName(@PathVariable("userName") String userName){
        return projectService.getProjectsIncludeName(userName);
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectCreateDto projectCreateDto){
        return projectService.createProject(projectCreateDto);
    }

    @DeleteMapping("/{projectId}")
    public ResultResponse deleteAccount(@PathVariable("projectId") Long projectId){
        projectService.deleteProject(projectId);
        return new ResultResponse("프로젝트 삭제가 완료되었습니다.");
    }



}
