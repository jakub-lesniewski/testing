import java.util.List;

public class Main {
    public static void main(String[] args) {
        KanbanBoard board = new KanbanBoard();

        Person alice = new Person("Alice");
        Person bob = new Person("Bob");

        Task task1 = new Task("Zadanie 1");
        Task task2 = new Task("Zadanie 2");
        task2.setAssignee(alice);

        board.addTask(task1);
        board.addTask(task2);

        System.out.println("Stan początkowy tablicy:");
        printBoardStatus(board);

        System.out.println("\nPrzenoszenie 'Zadanie 2' do statusu 'in progress':");
        board.moveTask(task2, "in progress");
        printBoardStatus(board);

        System.out.println("\nPrzenoszenie 'Zadanie 2' do statusu 'done':");
        board.moveTask(task2, "done");
        printBoardStatus(board);

        System.out.println("\nUsuwanie 'Zadanie 1':");
        board.removeTask(task1);
        printBoardStatus(board);
    }

    private static void printBoardStatus(KanbanBoard board) {
        System.out.println("Zadania 'New': " + board.getTasksNew());
        System.out.println("Zadania 'In Progress': " + board.getTasksInProgress());
        System.out.println("Zadania 'Done': " + board.getTasksDone());
    }
}
