package fr.chelie.TodoList.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoJPAService implements TodoService{

    @Autowired
    private TodoRepository repository;

    @Override
    public Todo create(Todo toCreate) {
        return repository.save(toCreate);
    }

    @Override
    public void delete(Long code) {
        repository.deleteById(code);
    }

    @Override
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(Todo toUpdate, Long code) {
        repository.deleteById(code);
        toUpdate.setCode(code);
        repository.save(toUpdate);
    }

    @Override
    public Todo getByCode(Long code) {
        Optional<Todo> todo = repository.findById(code);
        if(todo.isPresent()){
            return todo.get();
        }else{
            return null;
        }
    }

}
