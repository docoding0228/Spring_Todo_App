package com.sparta.todo_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private String todo_id;

}