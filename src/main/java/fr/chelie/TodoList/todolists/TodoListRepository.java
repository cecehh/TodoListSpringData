package fr.chelie.TodoList.todolists;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {
}
