package com.sparta.todo_app.entity;

import com.sparta.todo_app.dto.CommentRequestDto;
import com.sparta.todo_app.dto.ScheduleRequestDto;
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
@Table(name = "comments")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    public Comment update(String contents) {
        this.contents = contents;
        return this;
    }

    public Comment(CommentRequestDto requestDto, Schedule schedule) {
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
        this.schedule = schedule;
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