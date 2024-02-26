import java.util.ArrayList;
import java.util.List;

public abstract class Course {
    List<Student> studentList;
    String teacher;
    String department;
    int code;
    String title;
    int capacity;
    int credit;
    Class_time class_time;
    Exam_time exam_time;
    Type type;

    public Course(List<Student> studentList, String teacher, String department, int code, String title, int capacity, int credit, Class_time class_time, Exam_time exam_time, Type type) {
        this.studentList = studentList;
        this.teacher = teacher;
        this.department = department;
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.credit = credit;
        this.class_time = class_time;
        this.exam_time = exam_time;
        this.type = type;
    }
}