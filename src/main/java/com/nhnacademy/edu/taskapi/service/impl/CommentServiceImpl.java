package com.nhnacademy.edu.taskapi.service.impl;

import com.nhnacademy.edu.taskapi.domain.comment.CommentCreateDto;
import com.nhnacademy.edu.taskapi.domain.comment.CommentResponseDto;
import com.nhnacademy.edu.taskapi.domain.comment.CommentUpdateDto;
import com.nhnacademy.edu.taskapi.entity.Comment;
import com.nhnacademy.edu.taskapi.entity.Task;
import com.nhnacademy.edu.taskapi.repository.CommentRepository;
import com.nhnacademy.edu.taskapi.repository.TaskRepository;
import com.nhnacademy.edu.taskapi.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, TaskRepository taskRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<CommentResponseDto> getComments(Long taskNumber) {
        return commentRepository.findAllByTask_TaskNumber(taskNumber);
    }

    @Override
    public CommentResponseDto getComment(Long taskNumber, Long commentNumber) {
        return commentRepository.findByTask_TaskNumberAndCommentNumber(taskNumber, commentNumber);
    }

    @Override
    public CommentResponseDto createComment(Long taskNumber, CommentCreateDto commentCreateDto) {
        Task task = taskRepository.findById(taskNumber).orElse(null);

        Comment comment = new Comment();
        comment.setCommentContent(commentCreateDto.getCommentContent());
        comment.setUserId(commentCreateDto.getUserId());
        comment.setTask(task);
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);

        return new CommentResponseDto(comment.getUserId(), comment.getCommentContent(), comment.getCreatedAt());
    }

    @Override
    public CommentResponseDto updateComment(Long taskNumber, Long commentNumber, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findById(commentNumber).orElse(null);
        comment.setCommentContent(commentUpdateDto.getCommentContent());
        comment.setCreatedAt(LocalDateTime.now());


        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment.getUserId(), comment.getCommentContent(), comment.getCreatedAt());
        log.info("{}", commentResponseDto);
        return commentResponseDto;
    }

    @Override
    public void deleteComment(Long taskNumber, Long commentNumber) {
        commentRepository.deleteById(commentNumber);
    }
}
