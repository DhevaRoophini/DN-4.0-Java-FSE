class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String pos, double sal) {
        this.employeeId = id;
        this.name = name;
        this.position = pos;
        this.salary = sal;
    }
}

class DataStrucEx4 {
    static Employee[] employees = new Employee[100];
    static int count = 0;

    public static void add(Employee e) {
        employees[count++] = e;
    }

    public static Employee search(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id)
                return employees[i];
        }
        return null;
    }

    public static void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                count--;
                break;
            }
        }
    }

    public static void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].name);
        }
    }

    public static void main(String[] args) {
        add(new Employee(101, "John", "Dev", 30000));
        traverse();
        delete(101);
    }
}