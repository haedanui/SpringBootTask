package com.nhnacademy.edu.taskapi.controller;


import com.nhnacademy.edu.taskapi.domain.project.ProjectCreateDto;
import com.nhnacademy.edu.taskapi.domain.ResultResponse;
import com.nhnacademy.edu.taskapi.domain.project.ProjectInfoDto;
import com.nhnacademy.edu.taskapi.domain.project.ProjectUpdateDto;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectInfoDto> getProjects(){
        return projectService.getProjects();
    }

    //TODO (Project 멤버는 자신이 속한 Project 목록만 확인할 수 있습니다.)부분
    @GetMapping("/{userName}")
    public List<ProjectInfoDto> getProjectsIncludeName(@PathVariable("userName") String userName){
        return projectService.getProjectsIncludeName(userName);
    }


    @PostMapping
    public Project createProject(@RequestBody ProjectCreateDto projectCreateDto){
        return projectService.createProject(projectCreateDto);
    }

    @PutMapping("{projectId}/state")
    public Project updateProject(@PathVariable Long projectId,@RequestBody ProjectUpdateDto projectUpdateDto){
        return projectService.updateStatusProject(projectId, projectUpdateDto.getProjectState());
    }

    @DeleteMapping("/{projectId}")
    public ResultResponse deleteProject(@PathVariable("projectId") Long projectId){
        projectService.deleteProject(projectId);
        return new ResultResponse("프로젝트 삭제가 완료되었습니다.");
    }

}
