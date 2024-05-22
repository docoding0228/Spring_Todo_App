package com.sparta.todo_app.service;
import com.sparta.todo_app.dto.TodoRequestDto;
import com.sparta.todo_app.dto.TodoResponseDto;
import com.sparta.todo_app.entity.Todo;
import com.sparta.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto);
        Todo savedtodo = todoRepository.save(todo);
        return new TodoResponseDto(savedtodo);
    }

    public List<TodoResponseDto> getSchedules() {
        return todoRepository.findAll().stream().map(TodoResponseDto::new).toList();
    }
}

