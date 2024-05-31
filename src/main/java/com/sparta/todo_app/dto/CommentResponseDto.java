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
        private String contents;
        private Long scheduleId;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt;

        public CommentResponseDto(Comment comment) {
            this.id = comment.getId();
            this.contents = comment.getContents();
            this.scheduleId = comment.getSchedule().getId();
            this.createdAt = comment.getCreatedAt();
        }
    }
