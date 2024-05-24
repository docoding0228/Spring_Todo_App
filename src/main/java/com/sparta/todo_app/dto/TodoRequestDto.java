package com.sparta.todo_app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoRequestDto {

    @NotNull
    private String comment_content;

    @NotNull
    private String user_id;

    @NotNull
    private Long todo_id;

    // (1)
    public TodoRequestDto() {
        // 기본 생성자
    }
}