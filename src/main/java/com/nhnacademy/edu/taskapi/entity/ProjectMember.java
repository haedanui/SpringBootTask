package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ProjectMember")
@EqualsAndHashCode
public class ProjectMember {

    @EmbeddedId
    PK pk;

    @Column
    private Long projectId;

    @Column
    private String userName;

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

    //조인
    @ManyToOne
    @JoinColumn(name="projectId")
    private Project project;
}
