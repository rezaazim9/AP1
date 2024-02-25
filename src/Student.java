import java.util.List;

public class Student {
    int student_id;
    int password;
    List<Course> courses;
    public Student(int student_id,int password,List<Course> courses){
        this.password=password;
        this.student_id=student_id;
        this.courses=courses;
    }
}
