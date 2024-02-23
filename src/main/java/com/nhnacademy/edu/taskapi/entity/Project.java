package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


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

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectMember> projectMembers;

    public Project(Long projectId, String projectName, String projectState, String projectAdmin) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectState = projectState;
        this.projectAdmin = projectAdmin;
    }

    //    @OneToMany(mappedBy = "project")
//    private List<Tag> tags;

//    @OneToMany(mappedBy = "project")
//    private List<Task> tasks;

//    @OneToMany(mappedBy = "project")
//    private List<Milestone> milestones;
}
