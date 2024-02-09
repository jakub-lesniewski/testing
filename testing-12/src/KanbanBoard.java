import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KanbanBoard {
    private List<Task> tasksNew;
    private List<Task> tasksInProgress;
    private List<Task> tasksDone;

    public KanbanBoard() {
        tasksNew = new ArrayList<>();
        tasksInProgress = new ArrayList<>();
        tasksDone = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasksNew.add(task);
    }

    public void moveTask(Task task, String newStatus) {
        if (newStatus.equals("new")) {
            tasksInProgress.remove(task);
            tasksDone.remove(task);
            tasksNew.add(task);
        } else if (newStatus.equals("in progress")) {
            tasksNew.remove(task);
            tasksDone.remove(task);
            tasksInProgress.add(task);
        } else if (newStatus.equals("done")) {
            tasksNew.remove(task);
            tasksInProgress.remove(task);
            tasksDone.add(task);
        }
        task.setStatus(newStatus);
    }

    public void removeTask(Task task) {
        if (tasksNew.contains(task)) {
            tasksNew.remove(task);
        } else if (tasksInProgress.contains(task)) {
            tasksInProgress.remove(task);
        } else if (tasksDone.contains(task)) {
            tasksDone.remove(task);
        }
    }

    public List<Task> getTasksByStatus(String status) {
        switch (status) {
            case "new":
                return new ArrayList<>(tasksNew);
            case "in progress":
                return new ArrayList<>(tasksInProgress);
            case "done":
                return new ArrayList<>(tasksDone);
            default:
                return new ArrayList<>();
        }
    }

    public List<Task> getTasksByAssignee(Person assignee) {
        List<Task> allTasks = new ArrayList<>();
        allTasks.addAll(tasksNew);
        allTasks.addAll(tasksInProgress);
        allTasks.addAll(tasksDone);

        return allTasks.stream()
                .filter(task -> assignee.equals(task.getAssignee()))
                .collect(Collectors.toList());
    }

    public List<Task> getTasksNew() {
        return tasksNew;
    }

    public List<Task> getTasksInProgress() {
        return tasksInProgress;
    }

    public List<Task> getTasksDone() {
        return tasksDone;
    }
}
