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
            String obj_scanner = scanner.nextLine();
            if (obj_scanner.contains("Admin")) {
                String admin_password = obj_scanner.substring(14);
                Main.admin = new Admin("Admin", admin_password);
            }  if (obj_scanner.contains("Type: Special")) {
                List<Student> students = new ArrayList<>();
                String title = obj_scanner.substring(obj_scanner.indexOf("Title:") + 6, obj_scanner.indexOf(" Teacher"));
                String teacher = obj_scanner.substring(obj_scanner.indexOf("Teacher:") + 8, obj_scanner.indexOf(" Department"));
                String department = obj_scanner.substring(obj_scanner.indexOf("Department:") + 11, obj_scanner.indexOf(" code"));
                String code = obj_scanner.substring(obj_scanner.indexOf("code:") + 5, obj_scanner.indexOf(" Capacity"));
                String capacity = obj_scanner.substring(obj_scanner.indexOf("Capacity:") + 9, obj_scanner.indexOf(" Credit"));
                String credit = obj_scanner.substring(obj_scanner.indexOf("Credit:") + 7, obj_scanner.indexOf(" Day"));
                String day = obj_scanner.substring(obj_scanner.indexOf("Day:") + 4, obj_scanner.indexOf(" Start"));
                String day_start = obj_scanner.substring(obj_scanner.indexOf("Start:") + 6, obj_scanner.indexOf(" End"));
                String day_end = obj_scanner.substring(obj_scanner.indexOf("End:") + 4, obj_scanner.indexOf(" Exam"));
                String exam = obj_scanner.substring(obj_scanner.indexOf("Exam Day:") + 9, obj_scanner.indexOf(" start"));
                String exam_start = obj_scanner.substring(obj_scanner.indexOf("start:") + 6, obj_scanner.indexOf(" end"));
                String exam_end = obj_scanner.substring(obj_scanner.indexOf("end:") + 4, obj_scanner.indexOf(" Student"));
                Special_courses.special_courses.add(new Special_courses(students, teacher, department, Integer.parseInt(code), title, Integer.parseInt(capacity), Integer.parseInt(credit), new Class_time(day, Integer.parseInt(day_start), Integer.parseInt(day_end)), new Exam_time(exam, Integer.parseInt(exam_start), Integer.parseInt(exam_end)), Type.Special));
            } if (obj_scanner.contains("Type: General")) {
                List<Student> students = new ArrayList<>();
                String title = obj_scanner.substring(obj_scanner.indexOf("Title:") + 6, obj_scanner.indexOf(" Teacher"));
                String teacher = obj_scanner.substring(obj_scanner.indexOf("Teacher:") + 8, obj_scanner.indexOf(" Department"));
                String department = obj_scanner.substring(obj_scanner.indexOf("Department:") + 11, obj_scanner.indexOf(" code"));
                String code = obj_scanner.substring(obj_scanner.indexOf("code:") + 5, obj_scanner.indexOf(" Capacity"));
                String capacity = obj_scanner.substring(obj_scanner.indexOf("Capacity:") + 9, obj_scanner.indexOf(" Credit"));
                String credit = obj_scanner.substring(obj_scanner.indexOf("Credit:") + 7, obj_scanner.indexOf(" Day"));
                String day = obj_scanner.substring(obj_scanner.indexOf("Day:") + 4, obj_scanner.indexOf(" Start"));
                String day_start = obj_scanner.substring(obj_scanner.indexOf("Start:") + 6, obj_scanner.indexOf(" End"));
                String day_end = obj_scanner.substring(obj_scanner.indexOf("End:") + 4, obj_scanner.indexOf(" Exam"));
                String exam = obj_scanner.substring(obj_scanner.indexOf("Exam Day:") + 9, obj_scanner.indexOf(" start"));
                String exam_start = obj_scanner.substring(obj_scanner.indexOf("start:") + 6, obj_scanner.indexOf(" end"));
                String exam_end = obj_scanner.substring(obj_scanner.indexOf("end:") + 4, obj_scanner.indexOf(" Student"));
                General_courses.general_courses.add(new Special_courses(students, teacher, department, Integer.parseInt(code), title, Integer.parseInt(capacity), Integer.parseInt(credit), new Class_time(day, Integer.parseInt(day_start), Integer.parseInt(day_end)), new Exam_time(exam, Integer.parseInt(exam_start), Integer.parseInt(exam_end)), Type.General));
            } if (obj_scanner.contains("student id")) {
                String student_id = obj_scanner.substring(obj_scanner.indexOf("student id:") + 11, obj_scanner.indexOf(" password"));
                String password = obj_scanner.substring(obj_scanner.indexOf("password:") + 9, obj_scanner.indexOf(" credit"));
                String credit = obj_scanner.substring(obj_scanner.indexOf("credit:") + 7, obj_scanner.indexOf(" general credit"));
                String general = obj_scanner.substring(obj_scanner.indexOf("general credit:") + 15, obj_scanner.indexOf(" courses"));
                List<Course> courses = new ArrayList<>();
                for (Course i : Special_courses.special_courses) {
                    int index = 0;
                    while (obj_scanner.indexOf("Title:", index) != -1) {
                        if (i.code == Integer.parseInt(obj_scanner.substring(obj_scanner.indexOf("Code:", index) + 5, obj_scanner.indexOf(" Title:", index)))) {
                            courses.add(i);
                        }
                        index = obj_scanner.indexOf("Title:", index) + 1;
                    }
                }
                for (Course i : General_courses.general_courses) {
                    int index = 0;
                    while (obj_scanner.indexOf("Title:", index) != -1) {
                        if (i.code == Integer.parseInt(obj_scanner.substring(obj_scanner.indexOf("Code:", index) + 5, obj_scanner.indexOf(" Title:", index)))) {
                            courses.add(i);
                        }
                        index = obj_scanner.indexOf("Title:", index) + 1;
                    }
                }
                Main.studentList.add(new Student(Integer.parseInt(student_id), Integer.parseInt(password), courses, Integer.parseInt(credit), Integer.parseInt(general)));

            }
            for (Course course: General_courses.general_courses){
                for (Student student1:Main.studentList) {
                    if (!course.studentList.contains(student1)&&student1.courses.contains(course)) {
                        course.studentList.add(student1);
                    }
                    if (course.studentList.contains(student1)&&!student1.courses.contains(course)) {
                        student1.courses.add(course);
                    }
                }
            }
            for (Course course: Special_courses.special_courses){
                for (Student student1:Main.studentList) {
                    if (course.studentList.contains(student1)&&!student1.courses.contains(course)) {
                        student1.courses.add(course);
                    }
                    if (!course.studentList.contains(student1)&&student1.courses.contains(course)) {
                        course.studentList.add(student1);
                    }
                }
            }
        }
    }

    public static void add() throws IOException {
        FileWriter writer = new FileWriter("/home/reza/IdeaProjects/untitled/src/file.txt");
        writer.write("AdminPassword=123\n");
        for (Course i : Special_courses.special_courses) {
            StringBuilder students = new StringBuilder();
            int counter = 0;
            for (Student j : i.studentList) {
                counter++;
                students.append(" student ").append(counter).append(" id:").append(j.student_id);
            }
            writer.write("Type: Special" + " Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " Start:" + i.class_time.start + " End:" + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " Students:" + students + "\n");
        }
        for (Course i : General_courses.general_courses) {
            StringBuilder students = new StringBuilder();
            int counter = 0;
            for (Student j : i.studentList) {
                counter++;
                students.append(" student ").append(counter).append(" id:").append(j.student_id);
            }
            writer.write("Type: General" + " Title:" + i.title + " Teacher:" + i.teacher + " Department:" + i.department + " code:" + i.code + " Capacity:" + i.capacity + " Credit:" + i.credit + " Day:" + i.class_time.weekday + " Start:" + i.class_time.start + " End:" + i.class_time.end + " Exam Day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " Students:" + students + "\n");
        }
        for (Student i : Main.studentList) {
            StringBuilder courses = new StringBuilder();
            for (Course j : i.courses) {
                courses.append(" Code:").append(j.code).append(" Title:").append(j.title);
            }
            writer.write("student id:" + i.student_id + " password:" + i.password + " credit:" + i.credit + " general credit:" + i.general + " courses:" + courses + "\n");
        }
        writer.close();
    }
}
