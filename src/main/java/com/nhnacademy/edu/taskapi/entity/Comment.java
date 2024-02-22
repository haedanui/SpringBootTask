package com.nhnacademy.edu.taskapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Comment")
@EqualsAndHashCode
public class Comment {
    @Id
    @Column
    private Long commentNumber;

    @Column
    private Long taskNumber;

    @Column
    private String commentContent;

    @Column
    private String userNumber;

}
