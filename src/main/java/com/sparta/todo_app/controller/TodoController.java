package com.sparta.todo_app.controller;

import com.sparta.todo_app.dto.TodoRequestDto;
import com.sparta.todo_app.dto.TodoResponseDto;
import com.sparta.todo_app.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo Management", description = "일정 관리 페이지 API")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/post")
    public TodoResponseDto createTodo(@Valid @RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/todo")
    @Operation(summary = "선택한 댓글 조회")
    public TodoResponseDto getTodo(@RequestParam Long id) {
        return todoService.getTodo(id);
    }

    @GetMapping("/todos")
    @Operation(summary = "댓글 목록 조회")
    public List<TodoResponseDto> getTodoList() {
        return todoService.getTodos();
    }


    //    (1)
//    @PutMapping("/todo/{id}")
//    @Operation(summary = "일정 수정")
//    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
//        return todoService.updateTodo(id, requestDto);
//    }


//    @PutMapping("/todo")
//    @Operation(summary = "일정 수정")
//    public TodoResponseDto updateTodo(@RequestParam Long id, @Valid @RequestBody TodoRequestDto requestDto) {
//        return todoService.updateTodo(id, requestDto);
//    }

    //      (2)
    // @PutMapping("/todo/{id}") -> @PutMapping("/todo") // @PathVariable -> @RequestParam
    @PutMapping("/todo")
    @Operation(summary = "일정 수정")
    public TodoResponseDto updateTodo(@RequestParam Long id, @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(id, requestDto);
    }

    @DeleteMapping("/todo")
    @Operation(summary = "댓글 삭제")
    public Long deleteTodo(@RequestParam Long id) {
        return todoService.deleteTodo(id);
    }

}
