package fr.chelie.TodoList.todolists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListJPAService implements TodoListService {

    @Autowired
    private TodoListRepository repository;
    @Override
    public TodoList create(TodoList toCreate) {
        return repository.save(toCreate);
    }

    @Override
    public void delete(Long code) {
        repository.deleteById(code);
    }

    @Override
    public List<TodoList> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(TodoList toUpdate, Long code) {
        repository.deleteById(code);
        toUpdate.setCode(code);
        repository.save(toUpdate);
    }

    @Override
    public Optional<TodoList> getByCode(Long code) {
        return repository.findById(code);
    }
}
