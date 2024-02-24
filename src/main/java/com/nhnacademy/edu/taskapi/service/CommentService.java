package com.nhnacademy.edu.taskapi.service;

import com.nhnacademy.edu.taskapi.domain.comment.CommentCreateDto;
import com.nhnacademy.edu.taskapi.domain.comment.CommentResponseDto;
import com.nhnacademy.edu.taskapi.domain.comment.CommentUpdateDto;

import java.util.List;

public interface CommentService {

    List<CommentResponseDto> getComments(Long taskNumber);

    CommentResponseDto getComment(Long taskNumber, Long commentNumber);

    CommentResponseDto createComment(Long taskNumber, CommentCreateDto commentCreateDto);

    CommentResponseDto updateComment(Long taskNumber, Long commentNumber, CommentUpdateDto commentUpdateDto);

    void deleteComment(Long taskNumber, Long commentNumber);
}
