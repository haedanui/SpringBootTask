package com.nhnacademy.edu.taskapi.controller;

import com.nhnacademy.edu.taskapi.domain.ResultResponse;
import com.nhnacademy.edu.taskapi.domain.comment.CommentCreateDto;
import com.nhnacademy.edu.taskapi.domain.comment.CommentResponseDto;
import com.nhnacademy.edu.taskapi.domain.comment.CommentUpdateDto;
import com.nhnacademy.edu.taskapi.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/task/{taskNumber}") // 태스크 -> 코멘트
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/comments")
    public List<CommentResponseDto> getComments(@PathVariable("taskNumber") Long taskNumber) {
        return commentService.getComments(taskNumber);
    }

    @GetMapping("/comments/{commentNumber}")
    public CommentResponseDto getComment(@PathVariable("taskNumber") Long taskNumber, @PathVariable("commentNumber") Long commentNumber) {
        return commentService.getComment(taskNumber, commentNumber);
    }

    @PostMapping("/comments")
    public CommentResponseDto createComment(@PathVariable("taskNumber") Long taskNumber, @RequestBody CommentCreateDto commentCreateDto) {
        return commentService.createComment(taskNumber, commentCreateDto);
    }

    @PutMapping("/comments/{commentNumber}")
    public CommentResponseDto updateComment(@PathVariable("taskNumber") Long taskNumber, @PathVariable("commentNumber") Long commentNumber, @RequestBody CommentUpdateDto commentUpdateDto) {
        log.info("{}",commentUpdateDto);
        return commentService.updateComment(taskNumber, commentNumber, commentUpdateDto);
    }

    @DeleteMapping("/comments/{commentNumber}")
    public ResultResponse deleteComment(@PathVariable("taskNumber") Long taskNumber, @PathVariable("commentNumber") Long commentNumber) {
        commentService.deleteComment(taskNumber, commentNumber);
        return new ResultResponse("comment 삭제 완료!");
    }
}
