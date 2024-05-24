package com.sparta.todo_app.service;

import com.sparta.todo_app.dto.TodoRequestDto;
import com.sparta.todo_app.dto.TodoResponseDto;
import com.sparta.todo_app.entity.Todo;
import com.sparta.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto);
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponseDto(savedTodo);
    }

    public TodoResponseDto getTodo(Long id) {
        return new TodoResponseDto(findTodoById(id));
    }

    public List<TodoResponseDto> getTodos() {
        return todoRepository.findAll().stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoResponseDto updateTodo(Long id, TodoRequestDto requestDto) {
        Todo todo = findTodoById(id);
        todo.update(requestDto);
        return new TodoResponseDto(todo);
    }

    @Transactional
    public Long deleteTodo(Long id) {
        Todo todo = findTodoById(id);
        todoRepository.delete(todo);
        return id;
    }

    private Todo findTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 없습니다."));
    }

}
