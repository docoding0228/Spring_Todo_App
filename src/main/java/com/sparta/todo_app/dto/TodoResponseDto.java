package com.sparta.todo_app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.todo_app.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
    @AllArgsConstructor
    public class TodoResponseDto {

        private Long id;
        private String comment_content;
        private String user_id;
        private Long todo_id;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt;

        public TodoResponseDto(Todo todo) {
            this.id = todo.getId();
            this.comment_content = todo.getComment_content();
            this.user_id = todo.getUser_id();
            this.todo_id = todo.getTodo_id();
            this.createdAt = todo.getCreatedAt();
        }
    }
