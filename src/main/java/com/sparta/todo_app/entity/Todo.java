package com.sparta.todo_app.entity;

import com.sparta.todo_app.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "comment_content", nullable = false)
    private String comment_content;

    @Column(name = "user_id", nullable = false)
    private String user_id;

    @Column(name = "todo_id", nullable = false)
    private Long todo_id;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    public Todo(TodoRequestDto requestDto) {
        this.comment_content = requestDto.getComment_content();
        this.user_id = requestDto.getUser_id();
        this.todo_id = requestDto.getTodo_id();
    }

          // (1)
//        public void updateComment(String comment_content) {
//        if (comment_content != null) {
//            this.comment_content = comment_content;
//        }
//    }

//    (2)
//    public Todo update(TodoRequestDto todoRequestDto) {
//        this.comment_content = todoRequestDto.getComment_content();
//        return this;
//    }

}