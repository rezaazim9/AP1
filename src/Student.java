import java.util.List;

public class Student {
    int student_id;
    int password;
    int general;
    int credit;
    List<Course> courses;

    public Student(int student_id, int password, List<Course> courses,int credit,int general) {
        this.password = password;
        this.student_id = student_id;
        this.courses = courses;
        this.general=general;
        this.credit=credit;
    }
}
