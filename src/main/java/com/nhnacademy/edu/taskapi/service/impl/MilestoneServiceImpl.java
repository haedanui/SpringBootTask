package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.entity.Milestone;
import com.nhnacademy.edu.taskapi.repository.MilestoneRepository;
import com.nhnacademy.edu.taskapi.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneServiceImpl implements MilestoneService {

    MilestoneRepository milestoneRepository;

    @Autowired
    public MilestoneServiceImpl(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    @Override
    public List<Milestone> getMilestoneNumber() {
        return milestoneRepository.findAll();
    }

    @Override
    public Milestone getMilestoneNumber(Long milestoneNumber) {
        return milestoneRepository.findById(milestoneNumber).orElse(null);
    }

    @Override
    public Milestone createMilestoneNumber(Milestone milestone) {
        return milestoneRepository.save(milestone);
    }

    @Override
    public void deleteMilestoneNumber(Long milestoneNumber) {
        milestoneRepository.deleteById(milestoneNumber);
    }
}
