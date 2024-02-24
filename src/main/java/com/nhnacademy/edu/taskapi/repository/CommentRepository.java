package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.comment.CommentResponseDto;
import com.nhnacademy.edu.taskapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<CommentResponseDto> findAllByTask_TaskNumber(Long taskNumber);

    CommentResponseDto findByTask_TaskNumberAndCommentNumber(Long taskNumber, Long commentNumber);
}
