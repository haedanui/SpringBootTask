package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @EmbeddedId
    PK pk;

    @Column
    private String userName;

    public ProjectMember(PK pk, String userName) {
        this.pk = pk;
        this.userName = userName;
    }

    //조인
    @MapsId("projectId")
    @ManyToOne
    @JoinColumn(name="projectId")
    private Project project;



    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class PK implements Serializable {

        @Column
        private Long userNumber;

        @Column
        private Long projectId;
    }


}
