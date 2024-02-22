package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments();

    Comment getComment(Long commentNumber);

    Comment createComment(Comment comment);

    void deleteComment(Long commentNumber);
}
