package com.sparta.todo_app.service;

import com.sparta.todo_app.dto.CommentRequestDto;
import com.sparta.todo_app.dto.CommentResponseDto;
import com.sparta.todo_app.entity.Comment;
import com.sparta.todo_app.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentResponseDto createTodo(CommentRequestDto requestDto) {
        Comment todo = new Comment(requestDto);
        Comment savedTodo = commentRepository.save(todo);
        return new CommentResponseDto(savedTodo);
    }

    public CommentResponseDto getTodo(Long id) {
        return new CommentResponseDto(findTodoById(id));
    }

    public List<CommentResponseDto> getTodos() {
        return commentRepository.findAll().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }


      // (1)
//    @Transactional
//    public TodoResponseDto updateTodo(Long id, TodoRequestDto requestDto) {
//        Todo todo = findTodoById(id);
//        todo.updateComment(requestDto.getComment_content());
//        return new TodoResponseDto(todoRepository.save(todo));
//    }

    // (2)
    @Transactional
    public CommentResponseDto updateTodo(Long id, CommentRequestDto requestDto) {
        Comment todo = findTodoById(id);

        if (requestDto.getComment_content() != null) {
            todo.setComment_content(requestDto.getComment_content());
        }

        return new CommentResponseDto(commentRepository.save(todo));
    }

    @Transactional
    public Long deleteTodo(Long id) {
        Comment comment = findTodoById(id);
        commentRepository.delete(comment);
        return id;
    }

    private Comment findTodoById(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 없습니다."));
    }
}
