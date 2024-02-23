package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(name=
        "TaskWithProject", attributeNodes = {
        @NamedAttributeNode("project"),
})

@Getter
@Setter
@Entity
@Table(name = "Task")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @Column
    private Long taskNumber;

    @Column
    private String taskState;

    @Column
    private String taskTitle;

    @Column
    private String taskContent;


    //조인
//    @OneToMany(mappedBy = "task")
//    private List<ProjectTag> projectTags;
//
//    @OneToMany(mappedBy = "task")
//    private List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY)
    private Milestone milestone;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;


}
