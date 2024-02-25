package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.ResultResponse;
import com.nhnacademy.edu.taskapi.domain.milestone.MilestoneCreateDto;
import com.nhnacademy.edu.taskapi.domain.milestone.MilestoneResponseDto;
import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.service.MilestoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/projects/{projectId}/milestone") // 마일스톤은 프로젝트 내에서 생성 가능하고 사용 범위는 마일스톤을 생성한 프로젝트 내임.
public class MilestoneController {

    private final MilestoneService milestoneService;

    public MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }
    @GetMapping("/projects/{projectId}/milestone")
    public List<Milestone> getMilestones(@PathVariable("projectId") Long projectId) {
        return milestoneService.getMilestones(projectId);
    }

    @GetMapping("/projects/{projectId}/milestone/{milestoneNumber}")
    public Milestone getMileStone(@PathVariable("projectId") Long projectId, @PathVariable("milestoneNumber") Long mileStoneNumber) {
        return milestoneService.getMilestone(projectId, mileStoneNumber);
    }

    @PostMapping("/projects/{projectId}/milestone")
    public Milestone createMilestone(@PathVariable("projectId") Long projectId, @RequestBody MilestoneCreateDto milestoneCreateDto) {
        return milestoneService.createMilestone(projectId, milestoneCreateDto);
    }

    @DeleteMapping("/projects/{projectId}/milestone/{milestoneNumber}")
    public ResultResponse deleteMilestone(@PathVariable("projectId") Long projectId, @PathVariable("milestoneNumber") Long milestoneNumber) {
        milestoneService.deleteMilestoneNumber(projectId, milestoneNumber);

        return new ResultResponse("milestone 삭제 완료");
    }

    @GetMapping("/projects/{projectId}/task/{taskNumber}/milestone/{milestoneNumber}")
    public MilestoneResponseDto getMilestoneInTask(@PathVariable("projectId") Long projectId, @PathVariable("taskNumber") Long taskNumber, @PathVariable("milestoneNumber") Long milestoneNumber) {
        return milestoneService.getMilestoneInTask(projectId, taskNumber, milestoneNumber);
    }

    @PutMapping("/projects/{projectId}/task/{taskNumber}/milestone/{milestoneNumber}")
    public MilestoneResponseDto setMilestoneInTask(@PathVariable("projectId") Long projectId, @PathVariable("taskNumber") Long taskNumber, @PathVariable("milestoneNumber") Long milestoneNumber) {
        return milestoneService.setMilestoneInTask(projectId, taskNumber, milestoneNumber);
    }

//    @PutMapping("/projects/{projectId}/task/{taskNumber}/milestone/{milestoneNumber}")
//    public MilestoneResponseDto deleteMilestoneInTask(@PathVariable("projectId") Long projectId, @PathVariable("taskNumber") Long taskNumber, @PathVariable("milestoneNumber") Long milestoneNumber) {
//        return milestoneService.deleteMilestoneInTask(projectId, taskNumber, milestoneNumber);
//    }


}
