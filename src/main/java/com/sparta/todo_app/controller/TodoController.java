package com.sparta.todo_app.controller;

import com.sparta.todo_app.dto.TodoRequestDto;
import com.sparta.todo_app.dto.TodoResponseDto;
import com.sparta.todo_app.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo Management", description = "일정 관리 페이지 API")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public void TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/post")
    @Operation(summary = "게시글 작성")
    @Parameters({
            @Parameter(name = "comment_content", description = "내용", example = "제목입니다."),
            @Parameter(name = "user_id", description = "사용자 ID", example = "사용자 ID 입니다."),
            @Parameter(name = "todo_id", description = "일정 아이디", example = "일정 아이디 입니다.")
    })
    public TodoResponseDto createTodo(@Valid @RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }
}
