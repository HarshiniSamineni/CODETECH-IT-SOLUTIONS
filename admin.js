package studentgrademanagementsystem;
import java.util.HashMap;
import java.util.Map;

class Student {
    private String name;
    private String rollNumber;
    private Map<String, Integer> marks;

    public Student(String name, String rollNumber, Map<String, Integer> marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public double calculatePercentage() {
        double totalMarks = marks.values().stream().mapToInt(Integer::intValue).sum();
        return (totalMarks / (marks.size() * 100)) * 100;
    }

    public char calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }
}

class GradeManagementSystem {
    private Map<String, Student> students;

    public GradeManagementSystem() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getRollNumber(), student);
    }

    public void updateStudent(String rollNumber, Map<String, Integer> newMarks) {
        if (students.containsKey(rollNumber)) {
            students.get(rollNumber).getMarks().putAll(newMarks);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(String rollNumber) {
        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudentInfo(String rollNumber) {
        if (students.containsKey(rollNumber)) {
            Student student = students.get(rollNumber);
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("Percentage: " + student.calculatePercentage() + "%");
            System.out.println("Grade: " + student.calculateGrade());
        } else {
            System.out.println("Student not found.");
        }
    }
}
public class stdmgmt {
    public static void main(String[] args) {
        GradeManagementSystem system = new GradeManagementSystem();

        Student student1 = new Student("Vamshi", "V001", Map.of("Math", 95, "English",90, "Science", 94));
        Student student2 = new Student("Raju", "V002", Map.of("Math", 80, "English", 85, "Science", 93));

        system.addStudent(student1);
        system.addStudent(student2);

        system.displayStudentInfo("V001");

        system.updateStudent("V001", Map.of("Math", 98, "English", 85, "Science", 90));
        system.displayStudentInfo("V001");

        system.deleteStudent("V002");
        system.displayStudentInfo("V002");
    }
}