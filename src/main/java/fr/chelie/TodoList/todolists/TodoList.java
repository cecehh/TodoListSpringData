package fr.chelie.TodoList.todolists;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class TodoList {
    @Id
    private Long code;
    private String name;
    private List<fr.chelie.TodoList.todos.Todo> todos;

    public TodoList() {}

    public TodoList(Long code, String name, List<fr.chelie.TodoList.todos.Todo> todos) {
        this.code = code;
        this.name = name;
        this.todos = todos;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<fr.chelie.TodoList.todos.Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<fr.chelie.TodoList.todos.Todo> todos) {
        this.todos = todos;
    }
}
