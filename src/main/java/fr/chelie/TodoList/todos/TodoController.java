package fr.chelie.TodoList.todos;

import fr.chelie.TodoList.todolists.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping
    public List<fr.chelie.TodoList.todos.Todo> getAll() { return todoService.getAll();}

    @GetMapping("/{code}")
    public Todo getByCode(@PathVariable("code")  Long code){
        return todoService.getByCode(code);
    }
    @PostMapping
    public ResponseEntity createTodo(@RequestBody Todo toCreate){
        Todo todo = todoService.create(toCreate);
        return ResponseEntity.created(URI.create("/users/"+todo.getCode().toString())).build();
    }

    @PutMapping("/{code}")
    public ResponseEntity updateTodoList(@PathVariable("code") Long code, @RequestBody Todo todo) {
        todoService.update(todo, code );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteTodoList(@PathVariable("code") Long code) {
        todoService.delete(code);
        return ResponseEntity.noContent().build();
    }
}
