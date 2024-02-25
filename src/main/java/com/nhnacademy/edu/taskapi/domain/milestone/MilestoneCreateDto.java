package com.nhnacademy.edu.taskapi.domain.milestone;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MilestoneCreateDto {

    private String mileStoneName; // 마일스톤 이름

    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate dateStart; // 시작일

    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate dateFinish; // 마감일
}
