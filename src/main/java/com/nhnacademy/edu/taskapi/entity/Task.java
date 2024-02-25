package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long taskNumber;

    @Column
    private String taskState;

    @Column
    private String taskTitle;

    @Column
    private String taskContent;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;


}
