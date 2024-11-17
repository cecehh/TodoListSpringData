package fr.chelie.TodoList.TestTodos;

import fr.chelie.TodoList.todos.Todo;
import fr.chelie.TodoList.todos.TodoJPAService;
import fr.chelie.TodoList.todos.TodoRepository;
import fr.chelie.TodoList.todos.TodoState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
    private TodoJPAService service;

    @Mock
    private TodoRepository repository;

    private List<Todo> todos;

    @BeforeEach
    void setUp(){
        todos = List.of(
                new Todo(1L,"Todo 1 Test", TodoState.ACTIVE),
                new Todo(2L,"Todo 2 Test", TodoState.COMPLETED),
                new Todo(3L,"Todo 3 Test", TodoState.COMPLETED)
        );
        when(repository.findAll()).thenReturn(todos);
        when(repository.save(Mockito.any(Todo.class))).thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    void WhenQuerying_ShouldReturn_3(){
        assertEquals(3,service.getAll().size());
    }

    @Test
    void WhenQueryingFirst_ShouldBeTheSame(){
        assertEquals(todos.getFirst(),service.getAll().getFirst());
    }

    @Test
    void WhenQuerying_ShouldReturn_Active(){
        assertEquals(TodoState.ACTIVE,service.getAll().getFirst().getState());
    }

    @Test
    void WhenUpdating_ShouldHaveNewObject(){
        Todo newTodo = new Todo(5L,"text modif",TodoState.COMPLETED);

        service.create(newTodo);

        when(repository.findById(1L)).thenAnswer(i -> todos.getFirst());

        assertEquals(newTodo.getState(),service.getByCode(1L).getState());
    }


}
