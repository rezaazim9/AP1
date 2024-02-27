import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fileclass {
    static File obj = new File("/home/reza/IdeaProjects/untitled/src/file.txt");
    public static void add() throws IOException {
        FileWriter writer = new FileWriter("/home/reza/IdeaProjects/untitled/src/file.txt");
        writer.write("AdminPassword=123\n");
        for (Course i : Special_courses.special_courses) {
            writer.write("Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " " + i.class_time.start + " " + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " " + i.exam_time.start + " " + i.exam_time.end +" Students:"+i.studentList+ "\n");
        }
        for (Course i : General_courses.general_courses) {
            writer.write("Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " " + i.class_time.start + " " + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " " + i.exam_time.start + " " + i.exam_time.end +" Students:"+i.studentList+ "\n");
        }
        for (Student i : Main.studentList) {
            writer.write("student id:" + i.student_id + " password:" + i.password + " credit:" + i.credit + " general credit:" + i.general + " courses:" + i.courses+"\n");
        }
        writer.close();
    }
}
