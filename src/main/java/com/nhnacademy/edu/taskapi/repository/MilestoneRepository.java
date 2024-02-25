package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    List<Milestone> findByProject_ProjectId(Long projectId);

    Milestone findByProject_ProjectIdAndAndMilestoneNumber(Long projectId, Long milestoneNumber);

//    Milestone findByTask_TaskNumberAndMilestoneNumber(Long taskNumber, Long milestoneNumber);
}
