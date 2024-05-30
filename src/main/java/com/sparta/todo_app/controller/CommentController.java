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
@Tag(name = "Todo Management", description = "일정 관리 페이지 API")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post")
    public CommentResponseDto createTodo(@Valid @RequestBody CommentRequestDto requestDto) {
        return commentService.createTodo(requestDto);
    }

    @GetMapping("/todo")
    public CommentResponseDto getTodo(@RequestParam Long id) {
        return commentService.getTodo(id);
    }

    @GetMapping("/todos")
    public List<CommentResponseDto> getTodoList() {
        return commentService.getTodos();
    }


    //    (1)
//    @PutMapping("/todo/{id}")
//    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
//        return todoService.updateTodo(id, requestDto);
//    }


//    @PutMapping("/todo")
//    public TodoResponseDto updateTodo(@RequestParam Long id, @Valid @RequestBody TodoRequestDto requestDto) {
//        return todoService.updateTodo(id, requestDto);
//    }

    //      (2)
    // @PutMapping("/todo/{id}") -> @PutMapping("/todo") // @PathVariable -> @RequestParam
    @PutMapping("/todo")
    public CommentResponseDto updateTodo(@RequestParam Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateTodo(id, requestDto);
    }

    @DeleteMapping("/todo")
    public Long deleteTodo(@RequestParam Long id) {
        return commentService.deleteTodo(id);
    }

}
