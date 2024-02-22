package com.nhnacademy.edu.taskapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@NamedEntityGraph(name=
//        "TagWithProject", attributeNodes = {
//        @NamedAttributeNode("project")
//})

@Getter
@Setter
@Entity
@Table(name = "Tag")
@EqualsAndHashCode
public class Tag {

    @Id
    @Column
    private Long tagNumber;

    @Column
    private Long projectId;

    @Column
    private String tagName;

//    @ManyToOne
//    @JoinColumn(name = "projectId")
//    private Project project;

//    @OneToMany(mappedBy = "tag")
//    private List<ProjectTag> projectTags;

}
