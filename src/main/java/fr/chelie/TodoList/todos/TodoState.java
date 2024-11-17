package fr.chelie.TodoList.todos;

public enum TodoState {

    ACTIVE(1),
    COMPLETED(2);

    private final int value;

    private TodoState(int value){
        this.value = value;
    }

    public int getValue(){ return this.value;}


}
