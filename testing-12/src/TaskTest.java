import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void testCreateTask() {
        Task task = new Task("Task 1");
        assertEquals("Task 1", task.getDescription(), "The description should be correct");
    }

    @Test
    void testSetDescription() {
        Task task = new Task("Task 1");
        task.setDescription("Changed task description");
        assertEquals("Changed task description", task.getDescription(), "The task description should be changed.");
    }

    @Test
    void testSetStatus() {
        Task task = new Task("Task 1");
        task.setStatus("in progress");
        assertEquals("in progress", task.getStatus(), "The task status should be changed.");
    }

    @Test
    void testAssignPerson() {
        Task task = new Task("Task 1");
        Person person = new Person("Alice");
        task.setAssignee(person);
        assertEquals(person, task.getAssignee(), "The person assigned to the task should be set correctly.");
    }
}