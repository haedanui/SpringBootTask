package com.nhnacademy.edu.taskapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "Milestone")
public class Milestone {
    @Id
    @Column
    private Long milestoneNumber;

    @Column
    private Long taskNumber;

    @Column
    private LocalDateTime dateStart;

    @Column
    private LocalDateTime dateFinish;


    @OneToOne
    @JoinColumn(name = "taskNumber")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

}
