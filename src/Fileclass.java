import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Scanner;

public class Fileclass {
    public static void read() throws IOException {
        File obj = new File("/home/reza/IdeaProjects/untitled/src/file.txt");
        Scanner scanner = new Scanner(obj);
        while (scanner.hasNextLine()) {
            String course = scanner.nextLine();
            if (course.contains("Admin")) {
                continue;
            }
            List<Student> students = new ArrayList<>();
            String title = course.substring(course.indexOf("Title:") + 6, course.indexOf(" Teacher"));
            String teacher = course.substring(course.indexOf("Teacher:") + 8, course.indexOf(" Department"));
            String department = course.substring(course.indexOf("Department:") + 11, course.indexOf(" code"));
            String code = course.substring(course.indexOf("code:") + 5, course.indexOf(" Capacity"));
            String capacity = course.substring(course.indexOf("Capacity:") + 9, course.indexOf(" Credit"));
            String credit = course.substring(course.indexOf("Credit:") + 7, course.indexOf(" Day"));
            String day = course.substring(course.indexOf("Day:") + 4, course.indexOf(" Start"));
            String day_start = course.substring(course.indexOf("Start:") + 6, course.indexOf(" End"));
            String day_end = course.substring(course.indexOf("End:") + 4, course.indexOf(" Exam"));
            String exam = course.substring(course.indexOf("Exam Day:") + 9, course.indexOf(" start"));
            String exam_start = course.substring(course.indexOf("start:") + 6, course.indexOf(" end"));
            String exam_end = course.substring(course.indexOf("end:") + 4, course.indexOf(" Student"));
            int counter = 0;
            for (Student j : Main.studentList) {
                counter++;
                String counter_string = "";
                counter_string += counter;
                if (j.student_id == Integer.parseInt(course.substring(course.indexOf(counter + " id:") + counter_string.length() + 4, course.indexOf(" student" + counter++))))
                    ;
                students.add(j);
            }
            Special_courses.special_courses.add(new Special_courses(students, teacher, department, Integer.parseInt(code), title, Integer.parseInt(capacity), Integer.parseInt(credit), new Class_time(day, Integer.parseInt(day_start), Integer.parseInt(day_end)), new Exam_time(exam, Integer.parseInt(exam_start), Integer.parseInt(exam_end)), Type.Special));
        }

    }

    public static void add() throws IOException {
        FileWriter writer = new FileWriter("/home/reza/IdeaProjects/untitled/src/file.txt");
        writer.write("AdminPassword=123\n");
        int counter = 0;
        for (Student i : Main.studentList) {
            String courses = "";
            for (Course j : i.courses) {
                courses += " Title:" + j.title + " Code:" + j.code;
            }
            writer.write("student id:" + i.student_id + " password:" + i.password + " credit:" + i.credit + " general credit:" + i.general + " courses:" + courses + "\n");
        }
        for (Course i : Special_courses.special_courses) {
            String students = "";
            for (Student j : i.studentList) {
                counter++;
                students += " student " + counter + " id:" + j.student_id;
            }
            writer.write("Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " Start:" + i.class_time.start + " End:" + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " Students:" + students + "\n");
        }
        for (Course i : General_courses.general_courses) {
            String students = "";
            for (Student j : i.studentList) {
                students += " student id:" + j.student_id;
            }
            writer.write("Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " Start:" + i.class_time.start + " End:" + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " Students:" + students + "\n");
        }
        writer.flush();
        writer.close();
    }
}
