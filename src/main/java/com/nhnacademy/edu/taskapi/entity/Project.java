package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "Project")
@NoArgsConstructor
@AllArgsConstructor
public class Project {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column
    private String projectName;

    @Column
    private String projectState;

    @Column
    private String projectAdmin;
}
