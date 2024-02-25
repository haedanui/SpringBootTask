package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NamedEntityGraph(name=
        "ProjectTagWithTagWithTask", attributeNodes = {
        @NamedAttributeNode("tag"),
        @NamedAttributeNode("task")
})

@Getter
@Setter
@Entity
@Table(name = "ProjectTag")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTag {

    @EmbeddedId
    PK pk;

    @MapsId("tagNumber")
    @ManyToOne
    @JoinColumn(name = "tagNumber")
    private Tag tag;

    @MapsId("taskNumber")
    @ManyToOne
    @JoinColumn(name = "taskNumber")
    private Task task;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class PK implements Serializable {
        @Column
        private Long tagNumber;
        @Column
        private Long taskNumber;
    }
}
