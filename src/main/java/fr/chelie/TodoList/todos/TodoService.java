package fr.chelie.TodoList.todos;

import java.util.List;

public interface TodoService {

    public Todo create(Todo toCreate);
    public void delete(Long code);
    public List<Todo> getAll();
    public void update(Todo toUpdate,Long code);
    public Todo getByCode(Long code);
}
