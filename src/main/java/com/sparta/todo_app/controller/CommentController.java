package com.sparta.todo_app.controller;

import com.sparta.todo_app.dto.CommentRequestDto;
import com.sparta.todo_app.dto.CommentResponseDto;
import com.sparta.todo_app.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Comment Management", description = "일정 관리 페이지 API")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/comments")
    public CommentResponseDto createComment(@Valid @RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    @GetMapping("/comments")
    public CommentResponseDto getComment(@RequestParam Long id) {
        return commentService.getComment(id);
    }

    @GetMapping("/commentss")
    public List<CommentResponseDto> getTodoList() {
        return commentService.getComments();
    }

    //    (1)
//    @PutMapping("/todo/{id}")
//    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
//        return todoService.updateTodo(id, requestDto);
//    }


//    @PutMapping("/comments")
//    public CommentResponseDto updateComment(@RequestParam Long schedule, @Valid @RequestBody CommentRequestDto requestDto) {
//        return commentService.updateComment(schedule, requestDto);
//    }

    @PutMapping("/comments/{scheduleId}/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long scheduleId, @PathVariable Long commentId, @Valid @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(scheduleId, commentId, requestDto);
    }

    //      (2)
    // @PutMapping("/todo/{id}") -> @PutMapping("/todo") // @PathVariable -> @RequestParam
//    @PutMapping("/todo")
//    public CommentResponseDto updateTodo(@RequestParam Long id, @RequestBody CommentRequestDto requestDto) {
//        return commentService.updateTodo(id, requestDto);
//    }

    @DeleteMapping("/comments")
    public Long deleteTodo(@RequestParam Long id) {
        return commentService.deleteComment(id);
    }
}
