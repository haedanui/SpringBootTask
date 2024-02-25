package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.milestone.MilestoneCreateDto;
import com.nhnacademy.edu.taskapi.domain.milestone.MilestoneResponseDto;
import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.entity.Project;
import com.nhnacademy.edu.taskapi.entity.Task;
import com.nhnacademy.edu.taskapi.repository.MilestoneRepository;
import com.nhnacademy.edu.taskapi.repository.ProjectRepository;
import com.nhnacademy.edu.taskapi.repository.TaskRepository;
import com.nhnacademy.edu.taskapi.service.MilestoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {
    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;
    private final TaskRepository taskRepository;

    @Override
    public List<Milestone> getMilestones(Long projectId) {
        return milestoneRepository.findByProject_ProjectId(projectId);
    }

    @Override
    public Milestone getMilestone(Long projectId, Long milestoneNumber) {
        return milestoneRepository.findByProject_ProjectIdAndMilestoneNumber(projectId, milestoneNumber);
    }

    @Override
    public Milestone createMilestone(Long projectId, MilestoneCreateDto milestoneCreateDto) {
        Project project = projectRepository.findById(projectId).orElse(null);

        Milestone milestone = new Milestone();
        milestone.setMilestoneName(milestoneCreateDto.getMileStoneName());
        milestone.setDateStart(milestoneCreateDto.getDateStart());
        milestone.setDateFinish(milestoneCreateDto.getDateFinish());
        milestone.setProject(project);
        milestone.setTask(null); // 프로젝트 내에서 생성할 때는 taskNumber 를 null 로

        return milestoneRepository.save(milestone);

//        return new MilestoneResponseDto(milestone.getMilestoneName(), milestone.getDateStart(), milestone.getDateFinish());
    }

    @Override
    public void deleteMilestoneNumber(Long projectId, Long milestoneNumber) {
        milestoneRepository.deleteById(milestoneNumber);
    }

    @Override
    public MilestoneResponseDto setMilestoneInTask(Long projectId, Long taskNumber, Long milestoneNumber) {
        Milestone milestone = milestoneRepository.findById(milestoneNumber).orElse(null);

        Task task = taskRepository.findById(taskNumber).orElse(null);

        milestone.setTask(task);

        milestoneRepository.save(milestone);

        return new MilestoneResponseDto(milestone.getMilestoneName(), milestone.getDateStart(), milestone.getDateFinish(), milestone.getProject().getProjectId(), milestone.getTask().getTaskNumber());
    }

    @Override
    public MilestoneResponseDto getMilestoneInTask(Long projectId, Long taskNumber, Long milestoneNumber) {
        Milestone milestone = milestoneRepository.findByProject_ProjectIdAndTask_TaskNumberAndMilestoneNumber(projectId, taskNumber, milestoneNumber);
        return new MilestoneResponseDto(milestone.getMilestoneName(), milestone.getDateStart(), milestone.getDateFinish(), milestone.getProject().getProjectId(), milestone.getTask().getTaskNumber());
    }

    @Override
    public MilestoneResponseDto deleteMilestoneInTask(Long projectId, Long taskNumber, Long milestoneNumber) {
        Milestone milestone = milestoneRepository.findByProject_ProjectIdAndTask_TaskNumberAndMilestoneNumber(projectId, taskNumber, milestoneNumber);
        milestone.setTask(null);

        milestoneRepository.save(milestone);

        return new MilestoneResponseDto(milestone.getMilestoneName(), milestone.getDateStart(), milestone.getDateFinish(), milestone.getProject().getProjectId(), milestone.getTask().getTaskNumber());
    }


//    @Autowired
//    public MilestoneServiceImpl(MilestoneRepository milestoneRepository) {
//        this.milestoneRepository = milestoneRepository;
//    }
//
//    @Override
//    public List<Milestone> getMilestoneNumber() {
//        return milestoneRepository.findAll();
//    }
//
//    @Override
//    public Milestone getMilestoneNumber(Long milestoneNumber) {
//        return milestoneRepository.findById(milestoneNumber).orElse(null);
//    }
//
//    @Override
//    public Milestone createMilestoneNumber(Milestone milestone) {
//        return milestoneRepository.save(milestone);
//    }
//
//    @Override
//    public void deleteMilestoneNumber(Long milestoneNumber) {
//        milestoneRepository.deleteById(milestoneNumber);
//    }
}
