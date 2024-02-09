import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KanbanBoardTest {
    private KanbanBoard board;
    private Task task1;
    private Task task2;
    private Person person;

    @BeforeEach
    void setUp() {
        board = new KanbanBoard();
        task1 = new Task("Task 1");
        task2 = new Task("Task 2");
        person = new Person("Alice");
        task2.setAssignee(person);
    }

    @Test
    void testAddTask() {
        board.addTask(task1);
        assertEquals(1, board.getTasksNew().size(), "Table should contain a single task with 'new' status");
    }

    @Test
    void testMoveTask() {
        board.addTask(task1);
        board.moveTask(task1, "in progress");
        assertEquals(0, board.getTasksNew().size(), "Table should not contain any tasks with 'new' status");
        assertEquals(1, board.getTasksInProgress().size(), "Table should contain a single task 'in progress'");
    }
}