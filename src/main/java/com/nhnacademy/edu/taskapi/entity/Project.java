package com.nhnacademy.edu.taskapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "Project")
@NoArgsConstructor
@AllArgsConstructor
public class Project {


    @Id
//    @Column(name = "projectId")
    @JsonProperty("projectId")
    private Long projectId;

    @Column
    @JsonProperty("projectName")
    private String projectName;

    @Column
    @JsonProperty("projectState")
    private String projectState;

    @Column
    @JsonProperty("projectAdmin")
    private String projectAdmin;

//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ProjectMember> projectMembers;

//    @OneToMany(mappedBy = "project")
//    private List<Tag> tags;

//    @OneToMany(mappedBy = "project")
//    private List<Task> tasks;

//    @OneToMany(mappedBy = "project")
//    private List<Milestone> milestones;
}
