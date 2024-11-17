package fr.chelie.TodoList.TestTodoLists;

import fr.chelie.TodoList.todolists.TodoList;
import fr.chelie.TodoList.todolists.TodoListJPAService;
import fr.chelie.TodoList.todolists.TodoListRepository;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoListServiceTest {

    @InjectMocks
    private TodoListJPAService service;

    @Mock
    private TodoListRepository repository;

    private List<TodoList> todos;

    @BeforeEach
    void setUp(){
        todos = List.of(
                new TodoList(1L,"TodoList 1 Test", List.of(
                        new Todo(1L,"todo1",TodoState.COMPLETED),
                        new Todo(2L,"todo2",TodoState.ACTIVE)
                )),
                new TodoList(2L,"TodoList 2 Test", List.of(
                        new Todo(3L,"todo3",TodoState.COMPLETED),
                        new Todo(4L,"todo4",TodoState.ACTIVE)
                ))
        );
        when(repository.findAll()).thenReturn(todos);
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(todos.getFirst()));

    }

    @Test
    void WhenQuerying_ShouldReturn_3(){
        assertEquals(2,service.getAll().size());
    }

    @Test
    void WhenQueryingFirst_ShouldBeTheSame(){
        assertEquals(todos.getFirst(),service.getAll().getFirst());
    }

    @Test
    void WhenUpdating_ShouldHaveNewObject(){
        when(service.getByCode(1L)).thenAnswer(i -> todos.getFirst());

        TodoList todoList =  new TodoList(2L,"TodoList 2 Test", List.of(
                new Todo(6L,"todo6",TodoState.COMPLETED),
                new Todo(4L,"todo4",TodoState.ACTIVE)
        ));

        service.create(todoList);

        assertEquals(todoList,service.getByCode(2L));
    }
}
