package com.nhnacademy.edu.taskapi.service;



import com.nhnacademy.edu.taskapi.entity.Milestone;

import java.util.List;

public interface MilestoneService {

    List<Milestone> getMilestoneNumber();

    Milestone getMilestoneNumber(Long milestoneNumber);

    Milestone createMilestoneNumber(Milestone task);

    void deleteMilestoneNumber(Long milestoneNumber);
}
