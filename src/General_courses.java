import java.util.ArrayList;
import java.util.List;

public class General_courses extends Course {
    public General_courses(List<Student> studentList, String teacher, String department, int code, String title, int capacity, int credit, Class_time class_time, Exam_time exam_time, Type type) {
        super(studentList, teacher, department, code, title, capacity, credit, class_time, exam_time, type);
    }

    static List<Course> general_courses = new ArrayList<>();

    public static void add() {
        List<Student> math = new ArrayList<>();
        List<Student> physics = new ArrayList<>();
        List<Student> computer = new ArrayList<>();
        List<Student> chemistry = new ArrayList<>();
        general_courses.add(new General_courses(math, "Iman", "Maths", 100, "Andishe I", 3, 2, new Class_time("do_shanbe", 1, 3), new Exam_time("3_khordad", 1, 2), Type.General));
        general_courses.add(new General_courses(physics, "Javad", "Physics", 200, "Andishe II", 3, 2, new Class_time("se_shanbe", 6, 7), new Exam_time("3_khordad", 3, 4), Type.General));
        general_courses.add(new General_courses(computer, "Kambiz", "Computer", 300, "Andishe III", 3, 2, new Class_time("do_shanbe", 5, 6), new Exam_time("6_khordad", 4, 5), Type.General));
        general_courses.add(new General_courses(chemistry, "Leyla", "Chemistry", 400, "Andishe IIII", 3, 2, new Class_time("se_shanbe", 2, 4), new Exam_time("2_khordad", 4, 5), Type.General));

    }
}
