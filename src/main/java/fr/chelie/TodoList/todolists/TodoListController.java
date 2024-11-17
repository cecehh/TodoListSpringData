package fr.chelie.TodoList.todolists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todolists")
public class TodoListController{

    @Autowired
    private TodoListService todoListService;

    @GetMapping
    public List<TodoList> getAll() { return todoListService.getAll();}

    @GetMapping("/{code}")
    public Optional<TodoList> getByCode(@PathVariable("code")  Long code){
        return todoListService.getByCode(code);
    }
    @PostMapping
    public ResponseEntity createTodoList(@RequestBody TodoList toCreate){
        TodoList todoList = todoListService.create(toCreate);
        return ResponseEntity.created(URI.create("/users/"+todoList.getCode().toString())).build();
    }

    @PutMapping("/{code}")
    public ResponseEntity updateTodoList(@PathVariable("code") Long code, @RequestBody TodoList todoList) {
        todoListService.update(todoList, code );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteTodoList(@PathVariable("code") Long code) {
        todoListService.delete(code);
        return ResponseEntity.noContent().build();
    }

}
