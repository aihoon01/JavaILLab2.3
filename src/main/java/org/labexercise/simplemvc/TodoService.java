package org.labexercise.simplemvc;

import org.labexercise.simplemvc.db.ToDo;
import org.labexercise.simplemvc.dto.TodoDto;
import org.labexercise.simplemvc.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDto> getAllTodoItems() {
        List<ToDo> todos = todoRepository.findAll();
        return todos.stream().map(this::mapToTodoDto).collect(Collectors.toList());
    }

    public TodoDto createTodoItem(TodoDto todoDto) {
        ToDo todo = ToDo.builder()
                .title(todoDto.getTitle())
                .completed(todoDto.getCompleted())
                .build();
        var newTodo = todoRepository.save(todo);
        return TodoDto.builder()
                .id(newTodo.getId())
                .title(newTodo.getTitle())
                .completed(newTodo.getCompleted())
                .build();
    }

    private TodoDto mapToTodoDto(ToDo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }
}
