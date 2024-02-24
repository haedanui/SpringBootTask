package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedEntityGraph(name=
        "CommentWithTask", attributeNodes = {
        @NamedAttributeNode("task"),
})

@Getter
@Setter
@Entity
@Table(name = "Comment")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNumber;

    @Column
    private String commentContent;

    @Column
    private String userId; // userName -> userId로 수정

    @Column
    private LocalDateTime createdAt; // 등록일 추가

    @ManyToOne
    @JoinColumn(name = "taskNumber")
    private Task task;

    public Comment(Long commentNumber, String commentContent, String userId) {
        this.commentNumber = commentNumber;
        this.commentContent = commentContent;
        this.userId = userId;
    }
}
