package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(name=
        "TagWithProject", attributeNodes = {
        @NamedAttributeNode("project")
})

@Getter
@Setter
@Entity
@Table(name = "Tag")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @Column
    private Long tagNumber;

    @Column
    private String tagName;


    //작동 안함
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

//    @OneToMany(mappedBy = "tag")
//    private List<ProjectTag> projectTags;

}
