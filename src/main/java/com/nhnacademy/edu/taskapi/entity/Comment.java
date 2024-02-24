package com.nhnacademy.edu.taskapi.entity;

import lombok.*;

import javax.persistence.*;

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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNumber;

    @Column
    private String commentContent;

    @Column
    private String userName;

    @ManyToOne
    @JoinColumn(name = "taskNumber")
    private Task task;

    public Comment(Long commentNumber, String commentContent, String userName) {
        this.commentNumber = commentNumber;
        this.commentContent = commentContent;
        this.userName = userName;
    }
}
