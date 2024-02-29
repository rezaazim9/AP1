import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fileclass {
    public static void read() throws IOException {
        File obj = new File("/home/reza/IdeaProjects/untitled/src/file.txt");
        Scanner scanner = new Scanner(obj);
        while (scanner.hasNextLine()) {
            String student= scanner.nextLine();
            String course_general = scanner.nextLine();
            String course_special = scanner.nextLine();
            if (student.contains("student")) {
                String student_id = student.substring(student.indexOf("Title:") + 6, student.indexOf(" Teacher"));
                String password = student.substring(student.indexOf("Teacher:") + 8, student.indexOf(" Department"));
                String credit = student.substring(student.indexOf("Department:") + 11, student.indexOf(" code"));
                String general = student.substring(student.indexOf("code:") + 5, student.indexOf(" Capacity"));
                List<Course> courses = new ArrayList<>();
                Main.studentList.add(new Student(Integer.parseInt(student_id), Integer.parseInt(password), courses, Integer.parseInt(credit), Integer.parseInt(general)));
            }
            if (course_special.contains("General")) {
                List<Student> students = new ArrayList<>();
                String title = course_special.substring(course_special.indexOf("Title:") + 6, course_special.indexOf(" Teacher"));
                String teacher = course_special.substring(course_special.indexOf("Teacher:") + 8, course_special.indexOf(" Department"));
                String department = course_special.substring(course_special.indexOf("Department:") + 11, course_special.indexOf(" code"));
                String code = course_special.substring(course_special.indexOf("code:") + 5, course_special.indexOf(" Capacity"));
                String capacity = course_special.substring(course_special.indexOf("Capacity:") + 9, course_special.indexOf(" Credit"));
                String credit = course_special.substring(course_special.indexOf("Credit:") + 7, course_special.indexOf(" Day"));
                String day = course_special.substring(course_special.indexOf("Day:") + 4, course_special.indexOf(" Start"));
                String day_start = course_special.substring(course_special.indexOf("Start:") + 6, course_special.indexOf(" End"));
                String day_end = course_special.substring(course_special.indexOf("End:") + 4, course_special.indexOf(" Exam"));
                String exam = course_special.substring(course_special.indexOf("Exam Day:") + 9, course_special.indexOf(" start"));
                String exam_start = course_special.substring(course_special.indexOf("start:") + 6, course_special.indexOf(" end"));
                String exam_end = course_special.substring(course_special.indexOf("end:") + 4, course_special.indexOf(" Student"));
                Special_courses.special_courses.add(new Special_courses(students, teacher, department, Integer.parseInt(code), title, Integer.parseInt(capacity), Integer.parseInt(credit), new Class_time(day, Integer.parseInt(day_start), Integer.parseInt(day_end)), new Exam_time(exam, Integer.parseInt(exam_start), Integer.parseInt(exam_end)), Type.Special));
            }

            if (course_general.contains("General")) {
                List<Student> students = new ArrayList<>();
                String title = course_general.substring(course_general.indexOf("Title:") + 6, course_general.indexOf(" Teacher"));
                String teacher = course_general.substring(course_general.indexOf("Teacher:") + 8, course_general.indexOf(" Department"));
                String department = course_general.substring(course_general.indexOf("Department:") + 11, course_general.indexOf(" code"));
                String code = course_general.substring(course_general.indexOf("code:") + 5, course_general.indexOf(" Capacity"));
                String capacity = course_general.substring(course_general.indexOf("Capacity:") + 9, course_general.indexOf(" Credit"));
                String credit = course_general.substring(course_general.indexOf("Credit:") + 7, course_general.indexOf(" Day"));
                String day = course_general.substring(course_general.indexOf("Day:") + 4, course_general.indexOf(" Start"));
                String day_start = course_general.substring(course_general.indexOf("Start:") + 6, course_general.indexOf(" End"));
                String day_end = course_general.substring(course_general.indexOf("End:") + 4, course_general.indexOf(" Exam"));
                String exam = course_general.substring(course_general.indexOf("Exam Day:") + 9, course_general.indexOf(" start"));
                String exam_start = course_general.substring(course_general.indexOf("start:") + 6, course_general.indexOf(" end"));
                String exam_end = course_general.substring(course_general.indexOf("end:") + 4, course_general.indexOf(" Student"));
                General_courses.general_courses.add(new Special_courses(students, teacher, department, Integer.parseInt(code), title, Integer.parseInt(capacity), Integer.parseInt(credit), new Class_time(day, Integer.parseInt(day_start), Integer.parseInt(day_end)), new Exam_time(exam, Integer.parseInt(exam_start), Integer.parseInt(exam_end)), Type.General));
            }
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
            writer.write("Type: Special"+" Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " Start:" + i.class_time.start + " End:" + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " Students:" + students + "\n");
        }
        for (Course i : General_courses.general_courses) {
            String students = "";
            for (Student j : i.studentList) {
                students += " student id:" + j.student_id;
            }
            writer.write("Type: General"+"Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " Start:" + i.class_time.start + " End:" + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " Students:" + students + "\n");
        }
        writer.flush();
        writer.close();
    }
}
