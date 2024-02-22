package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

//@NamedEntityGraph(name=
//        "ProjectWithProjectMembers", attributeNodes = {
//        @NamedAttributeNode("projectMembers"),
//})

@Getter
@Setter
@Entity
@Table(name = "Project")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column
    private Long projectId;

    @Column
    private String projectName;

    @Column
    private String projectState;

    @Column
    private String projectAdmin;

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> projectMembers;

//    @OneToMany(mappedBy = "project")
//    private List<Tag> tags;

//    @OneToMany(mappedBy = "project")
//    private List<Task> tasks;

//    @OneToMany(mappedBy = "project")
//    private List<Milestone> milestones;
}
