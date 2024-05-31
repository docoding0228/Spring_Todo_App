package com.sparta.todo_app.service;

import com.sparta.todo_app.dto.CommentRequestDto;
import com.sparta.todo_app.dto.CommentResponseDto;
import com.sparta.todo_app.entity.Comment;
import com.sparta.todo_app.entity.Schedule;
import com.sparta.todo_app.repository.CommentRepository;
import com.sparta.todo_app.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

//    public CommentResponseDto createComment(CommentRequestDto requestDto) {
//        Comment todo = new Comment(requestDto);
//        Comment savedTodo = commentRepository.save(todo);
//        return new CommentResponseDto(savedTodo);
//    }

    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        Schedule schedule = findScheduleById(requestDto.getScheduleId());
        Comment comment = new Comment(requestDto, schedule);
        Comment savedComment = commentRepository.save(comment);
        return new CommentResponseDto(savedComment);
    }

    public CommentResponseDto getComment(Long id) {
        return new CommentResponseDto(findCommentById(id));
    }

    public List<CommentResponseDto> getComments() {
        return commentRepository.findAll().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }

      // (1)
//      @Transactional
//      public CommentResponseDto updateComment(Long scheduleId, CommentRequestDto requestDto) {
//        findScheduleById(scheduleId);
//        Comment comment = findCommentById(scheduleId);
//          return new CommentResponseDto(comment.update(requestDto.getContents()));
//      }
      @Transactional
      public CommentResponseDto updateComment(Long scheduleId, Long commentId, CommentRequestDto requestDto) {
          Schedule schedule = findScheduleById(scheduleId);
          Comment comment = findCommentById(commentId);
          if (!comment.getSchedule().getId().equals(scheduleId)) {
              throw new IllegalArgumentException("댓글이 선택한 일정과 일치하지 않습니다.");
          }
          return new CommentResponseDto(comment.update(requestDto.getContents()));
      }

    @Transactional
    public Long deleteComment(Long id) {
        Comment comment = findCommentById(id);
        commentRepository.delete(comment);
        return id;
    }

    private Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 없습니다."));
    }

    private Schedule findScheduleById(Long id) {
        // 선택한 일정 DB에서 찾기. 없으면 예외 처리.
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 없습니다."));
    }
}
