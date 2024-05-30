package com.sparta.todo_app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.todo_app.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
    @AllArgsConstructor
    public class CommentResponseDto {

        private Long id;
        private String comment_content;
        private String user_id;
        private Long todo_id;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt;

        public CommentResponseDto(Comment comment) {
            this.id = comment.getId();
            this.comment_content = comment.getComment_content();
            this.user_id = comment.getUser_id();
            this.todo_id = comment.getTodo_id();
            this.createdAt = comment.getCreatedAt();
        }
    }
