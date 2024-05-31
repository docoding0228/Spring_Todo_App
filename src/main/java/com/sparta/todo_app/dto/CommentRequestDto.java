package com.sparta.todo_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class CommentRequestDto {

    @NotBlank
    @Size(min = 1, max = 500)
    private String contents;

    @NotBlank
    private String username;

    @NotNull
    private Long scheduleId;
}