package fr.chelie.TodoList.todos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {

    private Long code;
    private String text;
    private TodoState state;

    public Todo() {
    }

    public Todo(Long code, String text, TodoState state) {
        this.code = code;
        this.text = text;
        this.state = state;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TodoState getState() {
        return state;
    }

    public void setState(TodoState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "code=" + code +
                ", text='" + text + '\'' +
                ", state=" + state +
                '}';
    }
}
