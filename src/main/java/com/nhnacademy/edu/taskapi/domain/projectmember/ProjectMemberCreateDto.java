package com.nhnacademy.edu.taskapi.domain.projectmember;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberCreateDto {
    private Long projectNumber;
    private String userName;
}