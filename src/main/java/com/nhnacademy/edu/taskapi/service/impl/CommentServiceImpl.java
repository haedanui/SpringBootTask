package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.entity.Comment;
import com.nhnacademy.edu.taskapi.repository.CommentRepository;
import com.nhnacademy.edu.taskapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getComment(Long commentNumber) {
        return commentRepository.findById(commentNumber).orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentNumber) {
        commentRepository.deleteById(commentNumber);
    }
}
