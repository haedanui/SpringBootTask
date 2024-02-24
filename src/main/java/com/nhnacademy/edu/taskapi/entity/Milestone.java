package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NamedEntityGraph(name=
        "MilestoneWithTaskWithProject", attributeNodes = {
        @NamedAttributeNode("project")
})

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "Milestone")
@NoArgsConstructor
@AllArgsConstructor
public class Milestone {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milestoneNumber;

    @Column
    private LocalDate dateStart;

    @Column
    private LocalDate dateFinish;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    public Milestone(Long milestoneNumber, LocalDate dateStart, LocalDate dateFinish) {
        this.milestoneNumber = milestoneNumber;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }




}
