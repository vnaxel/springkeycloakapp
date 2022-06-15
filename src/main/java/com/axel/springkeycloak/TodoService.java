package com.axel.springkeycloak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow();
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodoById(Long id, Todo todo) {
        Todo todoToUpdate = todoRepository.findById(id).orElseThrow();
        todoToUpdate.setValue(todo.getValue());
        return todoRepository.save(todoToUpdate);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
