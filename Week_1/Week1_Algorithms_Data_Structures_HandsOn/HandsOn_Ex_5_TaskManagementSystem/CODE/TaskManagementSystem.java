class Task {
    int taskId;
    String taskName, status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return taskId + " | " + taskName + " | " + status;
    }
}

public class TaskManagementSystem {
    Task head;

    public void add(Task t) {
        if (head == null) head = t;
        else {
            Task current = head;
            while (current.next != null) current = current.next;
            current.next = t;
        }
    }

    public Task search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void delete(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }
        if (temp.next != null) temp.next = temp.next.next;
    }

    public void display() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        tms.add(new Task(1, "Design UI", "Pending"));
        tms.add(new Task(2, "Backend API", "Ongoing"));
        tms.display();
        tms.delete(1);
        System.out.println("\nAfter Delete:");
        tms.display();
    }
}
