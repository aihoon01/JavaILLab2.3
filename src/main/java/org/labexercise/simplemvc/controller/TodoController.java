package org.labexercise.simplemvc.controller;


import org.labexercise.simplemvc.TodoService;
import org.labexercise.simplemvc.dto.TodoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("todo")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("all")
    public String displayAllTodoItems(Model model) {
        List<TodoDto> todoList = todoService.getAllTodoItems();
        model.addAttribute("todoList", todoList);
        return "todos";
    }

    @PostMapping("create")
    public String addTodoItem(Model model, @ModelAttribute TodoDto todoDto) {
        TodoDto newTodo = todoService.createTodoItem(todoDto);
        model.addAttribute("todoList", newTodo);
        return "todos";
    }

    @GetMapping()
    public String displayPage(Model model) {
        TodoDto todo = TodoDto.builder().build();
        model.addAttribute("todoDto", todo);
        model.addAttribute("message", "Welcome to the Todo App");
        return "todos_homepage";
    }
}
