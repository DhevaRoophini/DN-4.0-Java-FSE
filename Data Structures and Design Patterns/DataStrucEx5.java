class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
    }
}

class DataStrucEx5 {
    static Task head;

    public static void add(Task task) {
        if (head == null)
            head = task;
        else {
            Task temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = task;
        }
    }

    public static void traverse() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp.taskName);
            temp = temp.next;
        }
    }

    public static Task search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public static void delete(int id) {
        if (head == null)
            return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task prev = null, curr = head;
        while (curr != null && curr.taskId != id) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null)
            prev.next = curr.next;
    }

    public static void main(String[] args) {
        add(new Task(1, "Design", "Pending"));
        add(new Task(2, "Code", "Ongoing"));
        traverse();
        delete(1);
        traverse();
    }
}