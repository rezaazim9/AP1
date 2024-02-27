import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Main {
    static File obj = new File("/home/reza/IdeaProjects/untitled/src/file.txt");
    static FileWriter writer;

    static {
        try {
            writer = new FileWriter("/home/reza/IdeaProjects/untitled/src/file.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;
    static Admin admin;
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main_menu() throws IOException {
        int login_choice;
        int user_choice;
        while (true) {
            System.out.println("Sign up(1) Login(2) Exit(3)");
            login_choice = scanner.nextInt();
            if (login_choice == 3) {
                System.exit(0);
            } else if (login_choice == 1) {
                while (true) {
                    System.out.println("Student(1) Back(2)");
                    user_choice = scanner.nextInt();
                    if (user_choice == 2) {
                        break;
                    } else if (user_choice == 1) {
                        student_sign_up();
                    } else {
                        System.out.println("Choose between 1 ,2 !!!!!!");
                    }
                }
            } else if (login_choice == 2) {
                while (true) {
                    System.out.println("Student(1) Admin(2) Back(3)");
                    user_choice = scanner.nextInt();
                    if (user_choice == 3) {
                        break;
                    } else if (user_choice == 2) {
                        admin_login();
                    } else if (user_choice == 1) {
                        student_login();
                    } else {
                        System.out.println("Choose between 1 ,2 ,3 !!!!!!");
                    }
                }
            } else {
                System.out.println("Choose between 1 ,2 ,3 !!!!!!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String admin_password;
        Special_courses.add();
        General_courses.add();
        Fileclass.add();
        Scanner file_scanner = new Scanner(obj);
        admin_password = file_scanner.next().substring(14);
        admin = new Admin("Admin", admin_password);
        main_menu();
    }

    public static void admin_login() throws IOException {
        String password;
        while (true) {
            System.out.println("Please enter your password Back(1)");
            password = scanner.next();
            if (password.equals("1")) {
                break;
            } else if (admin.password.equals(password)) {
                System.out.println("Welcome");
                admin_menu();
            } else {
                System.out.println("Wrong password");
            }
        }
    }

    public static void student_sign_up() throws IOException {
        while (true) {
            System.out.println("Please enter your student ID Back(1)");
            int student_id = scanner.nextInt();
            if (student_id == 1) {
                break;
            }
            while (true) {
                System.out.println("Please enter your password (only numbers!!) Back(1)");
                int password = scanner.nextInt();
                if (password == 1) {
                    break;
                }
                List<Course> student_courses = new ArrayList<>();
                Student student = new Student(student_id, password, student_courses, 0, 0);
                studentList.add(student);
                student_menu(student);
            }
        }
    }

    public static void student_login() throws IOException {
        int student_id;
        int password;
        Student student;
        k:
        while (true) {
            System.out.println("Please enter you student ID Back(1)");
            student_id = scanner.nextInt();
            if (student_id == 1) {
                break;
            }
            for (Student i : studentList) {
                if (i.student_id == student_id) {
                    student = i;
                    while (true) {
                        System.out.println("Please enter you password Back(1)");
                        {
                            password = scanner.nextInt();
                            if (password == 1) {
                                continue k;
                            } else if (student.password == password) {
                                System.out.println("Welcome");
                                student_menu(student);
                            } else {
                                System.out.println("Wrong password");
                            }
                        }
                    }
                }
            }
            System.out.println("There no student with this ID");
        }
    }

    public static void student_menu(Student student) throws IOException {
        int choice;
        Fileclass.add();
        while (true) {
            System.out.println("My courses (1) Courses list (2) Back (3) main menu (0)");
            choice = scanner.nextInt();
            if (choice == 0) {
                main_menu();
            } else if (choice == 1) {
                if (student.courses.isEmpty()) {
                    System.out.println("No courses");
                } else {
                    for (Course i : student.courses) {
                        System.out.println(i.title);
                    }
                }
            } else if (choice == 2) {
                register_course(student);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Choose between 1 ,2 ,3 !!!!!!");
                break;
            }
        }
    }

    public static boolean check(Student student, Course course) {
        for (Course i : student.courses) {
            if (i.class_time.weekday.equals(course.class_time.weekday)) {
                if ((i.class_time.start <= course.class_time.end && i.class_time.start >= course.class_time.start) || (i.class_time.end <= course.class_time.end && i.class_time.end >= course.class_time.start)) {
                    return false;
                }
            }
        }
        for (Course i : student.courses) {
            if (i.exam_time.weekday.equals(course.exam_time.weekday)) {
                if ((i.exam_time.start <= course.exam_time.end && i.exam_time.start >= course.exam_time.start) || (i.exam_time.end <= course.exam_time.end && i.exam_time.end >= course.exam_time.start)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void add_remove(Student student) throws IOException {
        Fileclass.add();
        int course_choice;
        int choice_register;
        while (true) {
            boolean course_exist = false;
            System.out.println("Register course (1) Remove course (2) Back (3) main menu (0)");
            choice_register = scanner.nextInt();
            if (choice_register == 0) {
                main_menu();
            } else if (choice_register == 3) {
                break;
            } else if (choice_register == 2) {
                System.out.println("Enter course code Back(1)");
                course_choice = scanner.nextInt();
                if (course_choice == 1) {
                    break;
                }
                for (Course i : student.courses) {
                    if (i.code == course_choice) {
                        course_exist = true;
                        break;
                    }
                }
                for (Course i : Special_courses.special_courses) {
                    if (i.code == course_choice) {
                        student.courses.remove(i);
                        i.studentList.remove(student);
                        Fileclass.add();
                    }
                }
                for (Course i : General_courses.general_courses) {
                    if (i.code == course_choice) {
                        student.courses.remove(i);
                        i.studentList.remove(student);
                        Fileclass.add();
                    }
                }
                if (!course_exist) {
                    System.out.println("There is no course with this code");
                }
            } else if (choice_register == 1) {
                while (true) {
                    System.out.println("Enter course code Back(1)");
                    course_choice = scanner.nextInt();
                    if (course_choice == 1) {
                        break;
                    }
                    for (Course i : General_courses.general_courses) {
                        if (i.code == course_choice) {
                            student.credit += i.credit;
                            student.general += i.credit;
                            if (student.general > 5 || student.credit > 20 || !check(student, i)) {
                                System.out.println("Invalid");
                                student.credit -= i.credit;
                                student.general -= i.credit;

                            } else {
                                student.courses.add(i);
                                i.studentList.add(student);
                                Fileclass.add();
                            }
                        }
                    }
                    for (Course i : Special_courses.special_courses) {
                        if (i.code == course_choice) {
                            student.credit += i.credit;
                            if (student.general > 5 || student.credit > 20 || !check(student, i)) {
                                System.out.println("Invalid");
                                student.credit -= i.credit;
                            } else {
                                student.courses.add(i);
                                i.studentList.add(student);
                                Fileclass.add();
                            }
                        }
                    }
                }
            } else {
                System.out.println("Choose between 1 ,2 ,3 !!!!!!");
            }
        }
    }

    public static void register_course(Student student) throws IOException {
        Fileclass.add();
        int choice;
        while (true) {
            System.out.println("Choose faculty Maths (1) Physics (2) Computer (3) Chemistry (4) Back (5) main menu (0)");
            choice = scanner.nextInt();
            if (choice == 0) {
                main_menu();
            } else if (choice == 5) {
                break;
            } else if (choice == 1) {
                information("Maths");
                add_remove(student);
            } else if (choice == 2) {
                information("Physics");
                add_remove(student);
            } else if (choice == 3) {
                information("Computer");
                add_remove(student);
            } else if (choice == 4) {
                information("Chemistry");
                add_remove(student);
            } else {
                System.out.println("Choose between 1 ,2 ,3 ,4 ,5 !!!!!!");
            }
        }
    }

    public static void admin_menu() throws IOException {
        Fileclass.add();
        int choice;
        while (true) {
            System.out.println("Capacity (1) Students registration (2) Courses list (3) Adding-Removing course (4) Back(5) main menu (0)");
            choice = scanner.nextInt();
            if (choice == 0) {
                main_menu();
            } else if (choice == 5) {
                break;
            } else if (choice == 1) {
                capacity();
            } else if (choice == 2) {
                student_registration();
            } else if (choice == 3) {
                while (true) {
                    int choice_faculty;
                    System.out.println("Choose faculty Maths (1) Physics (2) Computer (3) Chemistry (4) Back (5)");
                    choice_faculty = scanner.nextInt();
                    if (choice_faculty == 5) {
                        break;
                    } else if (choice_faculty == 1) {
                        information("Maths");
                    } else if (choice_faculty == 2) {
                        information("Physics");
                    } else if (choice_faculty == 3) {
                        information("Computer");
                    } else if (choice_faculty == 4) {
                        information("Chemistry");
                    } else {
                        System.out.println("Choose between 1 ,2 ,3 ,4 ,5 !!!!!!");
                    }
                }
            } else if (choice == 4) {
                adding_removing_course();
            } else {
                System.out.println("Choose between 1 ,2 ,3 ,4 ,5 !!!!!!");
            }
        }
    }

    public static void information(String faculty) {
        for (Course i : Special_courses.special_courses) {
            if (i.department.equals(faculty)) {
                System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);
            }
        }
        for (Course i : General_courses.general_courses) {
            if (i.department.equals(faculty)) {
                System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);
            }
        }
    }

    public static void capacity() throws IOException {
        System.out.println("Enter course code Back (1)");
        int code = scanner.nextInt();
        int capacity;
        boolean course_exist = false;
        for (Course i : Special_courses.special_courses) {
            if (code == 1) {
                break;
            } else if (i.code == code) {
                course_exist = true;
                System.out.println("ADD capacity Back(123)");
                capacity = scanner.nextInt();
                if (capacity == 123) {
                    break;
                }
                i.capacity += capacity;
                Fileclass.add();
            }
        }
        for (Course i : General_courses.general_courses) {
            if (i.code == code) {
                course_exist = true;
                System.out.println("Add capacity Back(123)");
                capacity = scanner.nextInt();
                if (capacity == 123) {
                    break;
                }
                i.capacity += capacity;
                Fileclass.add();
            }
        }
        if (!course_exist && code != 1) {
            System.out.println("There is no course with this code!!!!!");
            capacity();
        }
    }

    public static void student_registration() throws IOException {
        k:
        while (true) {
            System.out.println("Enter course code Back (1)");
            int code = scanner.nextInt();
            int choice;
            int student_id;
            boolean student_exist = false;
            boolean course_exist = false;
            for (Course i : Special_courses.special_courses) {
                if (code == 1) {
                    break k;
                } else if (i.code == code) {
                    course_exist = true;
                    while (true) {
                        System.out.println("Student list (1) Add student (2) Remove student (3) Back (4) main menu (0)");
                        choice = scanner.nextInt();
                        if (choice == 0) {
                            main_menu();
                        } else if (choice == 4) {
                            break;
                        } else if (choice == 1) {
                            if (i.studentList.isEmpty()) {
                                System.out.println("No registration");
                            } else {
                                for (Student j : i.studentList) {
                                    System.out.println(j.student_id);
                                }
                            }
                        } else if (choice == 2) {
                            j:
                            while (true) {
                                System.out.println("Enter student ID Back (1)");
                                student_id = scanner.nextInt();
                                if (student_id == 1) {
                                    break;
                                }
                                for (Student k : studentList) {
                                    if (k.student_id == student_id) {
                                        student_exist = true;
                                        k.credit += i.credit;
                                        k.general += i.credit;
                                        if (i.studentList.size() < i.capacity && k.credit <= 20 && k.general <= 5 && check(k, i)) {
                                            i.studentList.add(k);
                                            k.courses.add(i);
                                            Fileclass.add();

                                        } else {
                                            System.out.println("Invalid");
                                            k.credit -= i.credit;
                                            k.general -= i.credit;
                                        }
                                        break j;
                                    }
                                }
                                if (!student_exist) {
                                    System.out.println("No student with this ID");
                                }
                            }
                        } else if (choice == 3) {
                            j:
                            while (true) {
                                System.out.println("Enter student ID Back (1)");
                                student_id = scanner.nextInt();
                                if (student_id == 1) {
                                    break;
                                }
                                for (Student k : studentList) {
                                    if (k.student_id == student_id) {
                                        student_exist = true;
                                        i.studentList.remove(k);
                                        k.courses.remove(i);
                                        k.credit += i.credit;
                                        Fileclass.add();
                                        if (i.type.type == 1) {
                                            k.general += i.credit;
                                        }
                                        break j;
                                    }
                                }
                                if (!student_exist) {
                                    System.out.println("No student with this ID");
                                }
                            }
                        } else {
                            System.out.println("Choose between 1 ,2 ,3 ,4 !!!!!!");
                        }
                    }
                }
            }
            for (Course i : General_courses.general_courses) {
                if (code == 1) {
                    break k;
                } else if (i.code == code) {
                    course_exist = true;
                    while (true) {
                        System.out.println("Student list (1) Add student (2) Remove student (3) Back (4) main menu (0)");
                        choice = scanner.nextInt();
                        if (choice == 0) {
                            main_menu();
                        } else if (choice == 4) {
                            break;
                        } else if (choice == 1) {
                            if (i.studentList.isEmpty()) {
                                System.out.println("No registration");
                            } else {
                                for (Student j : i.studentList) {
                                    System.out.println(j.student_id);
                                }
                            }
                        } else if (choice == 2) {
                            j:
                            while (true) {
                                System.out.println("Enter student ID Back (1)");
                                student_id = scanner.nextInt();
                                if (student_id == 1) {
                                    break;
                                }
                                for (Student k : studentList) {
                                    if (k.student_id == student_id) {
                                        student_exist = true;
                                        k.credit += i.credit;
                                        k.general += i.credit;
                                        if (i.studentList.size() < i.capacity && k.credit <= 20 && k.general <= 5 && check(k, i)) {
                                            i.studentList.add(k);
                                            k.courses.add(i);
                                            Fileclass.add();

                                        } else {
                                            System.out.println("Invalid");
                                            k.credit -= i.credit;
                                            k.general -= i.credit;
                                        }
                                        break j;
                                    }
                                }
                                if (!student_exist) {
                                    System.out.println("No student with this ID");
                                }
                            }
                        } else if (choice == 3) {
                            j:
                            while (true) {
                                System.out.println("Enter student ID Back (1)");
                                student_id = scanner.nextInt();
                                if (student_id == 1) {
                                    break;
                                }
                                for (Student k : studentList) {
                                    if (k.student_id == student_id) {
                                        student_exist = true;
                                        i.studentList.remove(k);
                                        k.courses.remove(i);
                                        k.credit += i.credit;
                                        Fileclass.add();
                                        if (i.type.type == 1) {
                                            k.general += i.credit;
                                        }
                                        break j;
                                    }
                                }
                                if (!student_exist) {
                                    System.out.println("No student with this ID");
                                }
                            }
                        } else {
                            System.out.println("Choose between 1 ,2 ,3 ,4 !!!!!!");
                        }
                    }
                }
            }
            if (!course_exist && code != 1) {
                System.out.println("There no course with this code");
                student_registration();
            }
        }
    }

    public static void adding_removing_course() throws IOException {
        int choice;
        while (true) {
            System.out.println("Add course (1) Remove course (2) Back (3) main menu (0)");
            choice = scanner.nextInt();
            if (choice == 0) {
                main_menu();
            } else if (choice == 3) {
                break;
            } else if (choice == 1) {
                add();
            } else if (choice == 2) {
                remove();
            } else {
                System.out.println("Choose between 1 ,2 ,3 !!!!!!");
            }
        }
    }

    public static void remove() throws IOException {
        Fileclass.add();
        int code;
        int choice;
        boolean course_exist = false;
        int type;
        while (true) {
            System.out.println("Enter course type General (1) Special (2) Back (3) main menu (0)");
            type = scanner.nextInt();
            if (type == 0) {
                main_menu();
            } else if (type == 3) {
                break;
            } else if (type == Type.General.type) {
                j:
                while (true) {
                    while (true) {
                        System.out.println("Choose faculty Maths (1) Physics (2) Computer (3) Chemistry (4) Back (5)");
                        choice = scanner.nextInt();
                        if (choice == 5) {
                            break j;
                        } else if (choice == 1) {
                            for (Course i : General_courses.general_courses) {
                                if (i.department.equals("Maths")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);
                                }
                            }
                            break;
                        } else if (choice == 2) {
                            for (Course i : General_courses.general_courses) {
                                if (i.department.equals("Physics")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 3) {
                            for (Course i : General_courses.general_courses) {
                                if (i.department.equals("Computer")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 4) {

                            for (Course i : General_courses.general_courses) {
                                if (i.department.equals("Chemistry")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else {
                            System.out.println("Choose between 1 ,2 ,3 ,4 ,5 !!!!!!");
                        }
                    }
                    System.out.println("Enter course code Back (1)");
                    code = scanner.nextInt();
                    int counter = 0;
                    String department = "";
                    for (Course i : General_courses.general_courses) {
                        if (i.code == code) {
                            department = i.department;
                            break;
                        }
                    }
                    for (Course i : General_courses.general_courses) {
                        if (i.department.equals(department)) {
                            counter++;
                        }
                    }
                    if (code == 1) {
                        break;
                    } else if (counter == 1) {
                        System.out.println("There is only one course in this department!!!!");
                        break;
                    }
                    for (Course i : General_courses.general_courses) {
                        if (i.code == code) {
                            course_exist = true;
                            General_courses.general_courses.remove(i);
                            Fileclass.add();
                            break j;
                        }
                    }
                    if (!course_exist) {
                        System.out.println("There is no course with this code!!!");
                    }
                }
            } else if (type == Type.Special.type) {
                j:
                while (true) {
                    while (true) {
                        System.out.println("Choose faculty Maths (1) Physics (2) Computer (3) Chemistry (4) Back (5)");
                        choice = scanner.nextInt();
                        if (choice == 5) {
                            break j;
                        } else if (choice == 1) {
                            for (Course i : Special_courses.special_courses) {
                                if (i.department.equals("Maths")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 2) {
                            for (Course i : Special_courses.special_courses) {
                                if (i.department.equals("Physics")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 3) {
                            for (Course i : Special_courses.special_courses) {
                                if (i.department.equals("Computer")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 4) {

                            for (Course i : Special_courses.special_courses) {
                                if (i.department.equals("Chemistry")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity + " number of students:" + i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else {
                            System.out.println("Choose between 1 ,2 ,3 ,4 ,5 !!!!!!");
                        }
                    }
                    System.out.println("Enter course code Back (1)");
                    code = scanner.nextInt();
                    int counter = 0;
                    String department = "";
                    for (Course i : Special_courses.special_courses) {
                        if (i.code == code) {
                            department = i.department;
                            break;
                        }
                    }
                    for (Course i : Special_courses.special_courses) {
                        if (i.department.equals(department)) {
                            counter++;
                        }
                    }
                    if (code == 1) {
                        break;
                    } else if (counter == 1) {
                        System.out.println("There is only one course in this department!!!!");
                        break;
                    }
                    for (Course i : Special_courses.special_courses) {
                        if (i.code == code) {
                            course_exist = true;
                            Special_courses.special_courses.remove(i);
                            Fileclass.add();
                            break j;
                        }
                    }
                    if (!course_exist) {
                        System.out.println("There is no course with this code!!!");
                    }
                }
            } else {
                System.out.println("General or Special!!!!");
            }
        }
    }

    public static void add() throws IOException {
        String teacher;
        List<Student> students = new ArrayList<>();
        String department;
        int code;
        String title;
        int capacity;
        int credit;
        String day;
        int start;
        int finish;
        String exam_day;
        int exam_start;
        int exam_finish;
        int type;
        k:
        while (true) {
            System.out.println("Enter type General (1) Special (2) Back (3) main menu (0)");
            type = scanner.nextInt();
            if (type == 0) {
                main_menu();
            } else if (type == 3) {
                break;
            } else if (type != 1 && type != 2) {
                System.out.println("Choose between 1 ,2 ,3 !!!!!!");
                add();
            }
            while (true) {
                System.out.println("Enter title Back (1)");
                title = scanner.next();
                if (title.equals("1")) {
                    break;
                }
                while (true) {
                    System.out.println("Enter teacher Back (1)");
                    teacher = scanner.next();
                    if (teacher.equals("1")) {
                        break;
                    }
                    while (true) {
                        System.out.println("Enter department Back (1)");
                        department = scanner.next();
                        if (department.equals("1")) {
                            break;
                        }
                        while (true) {
                            System.out.println("Enter code Back (1)");
                            code = scanner.nextInt();
                            if (code == 1) {
                                break;
                            }
                            while (true) {
                                System.out.println("Enter capacity Back (1)");
                                capacity = scanner.nextInt();
                                if (capacity == 1) {
                                    break;
                                }
                                while (true) {
                                    System.out.println("Enter credit Back (1)");
                                    credit = scanner.nextInt();
                                    if (credit == 1) {
                                        break;
                                    }
                                    while (true) {
                                        System.out.println("Enter class time Back (1 first)");
                                        day = scanner.next();
                                        if (day.equals("1")) {
                                            break;
                                        }
                                        start = scanner.nextInt();
                                        finish = scanner.nextInt();
                                        while (true) {
                                            System.out.println("Enter exam time Back (1 first)");
                                            exam_day = scanner.next();
                                            if (exam_day.equals("1")) {
                                                break;
                                            }
                                            exam_start = scanner.nextInt();
                                            exam_finish = scanner.nextInt();
                                            if (type == Type.General.type) {
                                                Course new_course = new General_courses(students, teacher, department, code, title, capacity, credit, new Class_time(day, start, finish), new Exam_time(exam_day, exam_start, exam_finish), Type.General);
                                                General_courses.general_courses.add(new_course);
                                                break k;
                                            } else if (type == Type.Special.type) {
                                                Course new_course = new General_courses(students, teacher, department, code, title, capacity, credit, new Class_time(day, start, finish), new Exam_time(exam_day, exam_start, exam_finish), Type.Special);
                                                Special_courses.special_courses.add(new_course);
                                                break k;
                                            }
                                            Fileclass.add();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}