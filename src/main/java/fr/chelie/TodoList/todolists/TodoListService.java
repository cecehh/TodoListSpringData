package fr.chelie.TodoList.todolists;

import java.util.List;
import java.util.Optional;

public interface TodoListService {
    public TodoList create(TodoList toCreate);
    public void delete(Long code);
    public List<TodoList> getAll();
    public void update(TodoList toUpdate, Long code);
    public Optional<TodoList> getByCode(Long code);
}
