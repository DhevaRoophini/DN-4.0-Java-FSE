class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentView {
    public void displayStudentDetails(Student s) {
        System.out.println("Student: " + s.getName() + ", ID: " + s.getId() + ", Grade: " + s.getGrade());
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.displayStudentDetails(model);
    }
}

class DesignEx10 {
    public static void main(String[] args) {
        Student s = new Student("John", 101, "A");
        StudentView v = new StudentView();
        StudentController c = new StudentController(s, v);
        c.updateView();
    }
}