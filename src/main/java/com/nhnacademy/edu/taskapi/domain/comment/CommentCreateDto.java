package com.nhnacademy.edu.taskapi.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentCreateDto {
    private String userId;
    private String commentContent;
}
