import java.util.ArrayList;
import java.util.List;

public class General_courses extends Course{
    public General_courses(List<Student> studentList, String teacher, String department, int code, String title, int capacity, int credit, Class_time class_time, Exam_time exam_time, Type type) {
        super(studentList, teacher, department, code, title, capacity, credit, class_time, exam_time, type);
    }
    static List<Course> general_courses=new ArrayList<>();
    public static void add(){
        List<Student> math1=new ArrayList<>();
        List<Student> physics1=new ArrayList<>();
        List<Student> computer1=new ArrayList<>();
        List<Student> chemistry1=new ArrayList<>();
        general_courses.add(new Special_courses(math1,"Iman","Maths",100,"Andishe I",3,2,new Class_time("do_shanbe",1,3),new Exam_time("3_khordad",2,3),Type.General));
        general_courses.add(new Special_courses(physics1,"Javad","Physics",200,"Andishe II",3,2,new Class_time("se_shanbe",6,7),new Exam_time("3_khordad",3,4),Type.General));
        general_courses.add(new Special_courses(computer1,"Kambiz","Computer",300,"Andishe III",3,2,new Class_time("do_shanbe",5,6),new Exam_time("6_khordad",4,5),Type.General));
        general_courses.add(new Special_courses(chemistry1,"Leyla","Chemistry",400,"Andishe IIII",3,2,new Class_time("se_shanbe",2,4),new Exam_time("2_khordad",4,5),Type.General));

    }
}
