package com.nhnacademy.edu.taskapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
public class Milestone implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milestoneNumber;

    @Column
    private String milestoneName; // 마일스톤 이름 추가

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinish;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @OneToOne
    @JoinColumn(name = "taskNumber")
    private Task task; // 마일스톤이 태스크넘버 가지는걸로 수정

//    public Milestone(Long milestoneNumber, LocalDate dateStart, LocalDate dateFinish) {
//        this.milestoneNumber = milestoneNumber;
//        this.dateStart = dateStart;
//        this.dateFinish = dateFinish;
//    }

}
