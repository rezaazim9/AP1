import java.util.ArrayList;
import java.util.List;

public class Special_courses extends Course {
    public Special_courses(List<Student> studentList, String teacher, String department, int code, String title, int capacity, int credit, Class_time class_time, Exam_time exam_time, Type type) {
        super(studentList, teacher, department, code, title, capacity, credit, class_time, exam_time, type);
    }

    static List<Course> special_courses = new ArrayList<>();

    public static void add() {
        List<Student> math1 = new ArrayList<>();
        List<Student> math2 = new ArrayList<>();
        List<Student> physics1 = new ArrayList<>();
        List<Student> physics2 = new ArrayList<>();
        List<Student> computer1 = new ArrayList<>();
        List<Student> computer2 = new ArrayList<>();
        List<Student> chemistry1 = new ArrayList<>();
        List<Student> chemistry2 = new ArrayList<>();
        special_courses.add(new Special_courses(math1, "Abas", "Maths", 101, "General Mathematics I", 6, 4, new Class_time("shanbe", 1, 3), new Exam_time("3_khordad", 2, 5), Type.Special));
        special_courses.add(new Special_courses(math2, "Babak", "Maths", 102, "General Mathematics II", 3, 4, new Class_time("shanbe", 4, 5), new Exam_time("3_khordad", 1, 4), Type.Special));
        special_courses.add(new Special_courses(physics1, "Cina", "Physics", 201, "General Physics I", 6, 3, new Class_time("yek_shanbe", 1, 3), new Exam_time("5_khordad", 2, 5), Type.Special));
        special_courses.add(new Special_courses(physics2, "Davood", "Physics", 202, "General Physics II", 3, 3, new Class_time("yek_shanbe", 6, 7), new Exam_time("3_khordad", 3, 6), Type.Special));
        special_courses.add(new Special_courses(computer1, "Ebrahim", "Computer", 301, "Basic Programming", 6, 3, new Class_time("shanbe", 2, 4), new Exam_time("5_khordad", 2, 5), Type.Special));
        special_courses.add(new Special_courses(computer2, "Farid", "Computer", 302, "Advance Programming", 3, 4, new Class_time("yek_shanbe", 5, 6), new Exam_time("6_khordad", 2, 5), Type.Special));
        special_courses.add(new Special_courses(chemistry1, "Gol", "Chemistry", 401, "General Chemistry I", 6, 3, new Class_time("yek_shanbe", 2, 4), new Exam_time("2_khordad", 2, 5), Type.Special));
        special_courses.add(new Special_courses(chemistry2, "Hamid", "Chemistry", 402, "General Chemistry II", 3, 3, new Class_time("shanbe", 4, 6), new Exam_time("1_khordad", 2, 5), Type.Special));
    }
}
