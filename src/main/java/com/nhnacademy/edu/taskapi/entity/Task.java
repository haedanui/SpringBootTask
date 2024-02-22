package com.nhnacademy.edu.taskapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Task")
@EqualsAndHashCode
public class Task {

    @Id
    @Column
    private Long taskNumber;

    @Column
    private Long projectId;

    @Column
    private String taskState;

    @Column
    private String taskTitle;

    @Column
    private String taskContent;


//    //조인
//    @OneToMany(mappedBy = "task")
//    private List<ProjectTag> projectTags;
//
//    @OneToMany(mappedBy = "task")
//    private List<Comment> comments;

    @OneToOne
    private Milestone milestone;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;


}
