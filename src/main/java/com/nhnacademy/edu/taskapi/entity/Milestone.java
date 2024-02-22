package com.nhnacademy.edu.taskapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NamedEntityGraph(name=
        "MilestoneWithTaskWithProject", attributeNodes = {
        @NamedAttributeNode("task"),
        @NamedAttributeNode("project")
})

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
    private LocalDateTime dateStart;

    @Column
    private LocalDateTime dateFinish;

//이부분 오류남
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskNumber")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

}
