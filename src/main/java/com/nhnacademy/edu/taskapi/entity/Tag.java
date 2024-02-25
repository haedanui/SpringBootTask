package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagNumber;

    @Column
    private String tagName;


    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

}