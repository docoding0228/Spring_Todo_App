package com.sparta.todo_app.dto;

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
        private String todo_id;
        private LocalDateTime createdAt;

        public TodoResponseDto(Todo todo) {
            this.id = todo.getId();
            this.comment_content = todo.getComment_content();
            this.user_id = todo.getUser_id();
            this.todo_id = todo.getTodo_id();
            this.createdAt = todo.getCreatedAt();
        }
    }
