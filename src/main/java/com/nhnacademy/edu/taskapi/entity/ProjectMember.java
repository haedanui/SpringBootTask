package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;

@NamedEntityGraph(name=
        "ProjectMemberWithProject", attributeNodes = {
        @NamedAttributeNode("project"),
})

@Getter
@Setter
@Entity
@Table(name = "ProjectMember")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNumber;

    @Column
    private String userName;

    @Column
    private Long projectNumber;

    //조인
    @ManyToOne
    @JoinColumn(name="projectId")
    private Project project;
}