package com.nhnacademy.edu.taskapi.service;



import com.nhnacademy.edu.taskapi.domain.milestone.MilestoneCreateDto;
import com.nhnacademy.edu.taskapi.domain.milestone.MilestoneResponseDto;
import com.nhnacademy.edu.taskapi.entity.Milestone;

import java.util.List;

public interface MilestoneService {

    List<Milestone> getMilestones(Long projectId); // 한 프로젝트 내에서 생성된 모든 마일스톤들을 가져옴

    Milestone getMilestone(Long projectId, Long milestoneNumber); // 프로젝트 아이디 + 마일스톤 넘버로 특정 마일스톤 가져옴

    Milestone createMilestone(Long projectId, MilestoneCreateDto milestoneCreateDto); // 한 프로젝트 내에서 마일스톤 생성

    void deleteMilestoneNumber(Long projectId, Long milestoneNumber); // 프로젝트 아이디 + 마일스톤 넘버로 선택한 마일스톤 삭제

    MilestoneResponseDto setMilestoneInTask(Long projectId, Long taskNumber, Long milestoneNumber); // 태스크에서 생성 되어있는 마일스톤 중 하나를 설정

    MilestoneResponseDto getMilestoneInTask(Long projectId, Long taskNumber, Long milestoneNumber); // 태스크에 설정된 마일스톤 가져옴

    MilestoneResponseDto deleteMilestoneInTask(Long projectId, Long taskNumber, Long milestoneNumber); // 태스크에서 마일스톤 없음 으로 설정할 경우

}
