import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Admin admin;
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Special_courses.add();
        General_courses.add();
        int login_choice;
        int user_choice;
        admin = new Admin("Admin", 123);
        while (true) {
            System.out.println("Sign up(1) Login(2) Exit(3)");
            login_choice = scanner.nextInt();
            if (login_choice == 3) {
                break;
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

    public static void admin_login() {
        int password;
        while (true) {
            System.out.println("Please enter your password Back(1)");
            password = scanner.nextInt();
            if (1 == password) {
                break;
            } else if (admin.password == password) {
                System.out.println("Welcome");
                admin_menu();
            } else {
                System.out.println("Wrong password");
            }
        }

    }

    public static void student_sign_up() {
        while (true) {
            System.out.println("Please enter your student ID Back(1)");
            int student_id = scanner.nextInt();
            if (student_id == 1) {
                break;
            }
            while (true) {
                System.out.println("Please enter your password (only numbers!!) Back(1)");
                int password = scanner.nextInt();
                if (password==1){
                    break;
                }
                Student student = new Student(student_id, password, null);
                studentList.add(student);
                student_menu(student);
            }
        }
    }

    public static void student_login() {
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

    public static void student_menu(Student student) {
        int choice;
        while (true) {
            System.out.println("My courses (1) Courses list (2) Back (3)");
            choice = scanner.nextInt();
            if (choice == 1) {
                if (student.courses == null) {
                    System.out.println("No courses");
                } else {
                    for (Course i : student.courses) {
                        System.out.print(i.title + " ");
                    }
                }
            } else if (choice == 2) {
                int choice_faculty;
                while (true) {
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
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Choose between 1 ,2 ,3 !!!!!!");
                break;
            }
        }
    }

    public static void admin_menu() {
        int choice;
        while (true) {
            System.out.println("Capacity (1) Students registration (2) Courses list (3) Adding-Removing course (4) Back(5)");
            choice = scanner.nextInt();
            if (choice == 5) {
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
                System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);
            }
        }
        for (Course i : General_courses.general_courses) {
            if (i.department.equals(faculty)) {
                System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);
            }
        }
    }

    public static void capacity() {
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
            }
        }
        if (!course_exist && code != 1) {
            System.out.println("There is no course with this code!!!!!");
            capacity();
        }
    }

    public static void student_registration() {
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
                        System.out.println("Student list (1) Add student (2) Remove student (3) Back (4)");
                        choice = scanner.nextInt();
                        if (choice == 4) {
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
                                        if (i.studentList.size()<i.capacity) {
                                            i.studentList.add(k);
                                        }
                                        else {
                                            System.out.println("The capacity is full!!");
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
                        System.out.println("Student list (1) Add student (2) Remove student (3) Back (4)");
                        choice = scanner.nextInt();
                        if (choice == 4) {
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
                                        if (i.studentList.size()<=i.capacity) {
                                            i.studentList.add(k);
                                        }
                                        else {
                                            System.out.println("The capacity is full!!");
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
                                        break j;
                                    }
                                }
                                if (!student_exist) {
                                    System.out.println("No student with this ID");
                                }
                            }
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

    public static void adding_removing_course() {
        int choice;
        while (true) {
            System.out.println("Add course (1) Remove course (2) Back (3)");
            choice = scanner.nextInt();
            if (choice == 3) {
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

    public static void remove() {
        int code;
        int choice;
        boolean course_exist = false;
        int type;
        while (true) {
            System.out.println("Enter course type General (1) Special (2) Back (3)");
            type = scanner.nextInt();
            if (type == 3) {
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
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 2) {
                            for (Course i : General_courses.general_courses) {
                                if (i.department.equals("Physics")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 3) {
                            for (Course i : General_courses.general_courses) {
                                if (i.department.equals("Computer")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 4) {

                            for (Course i : General_courses.general_courses) {
                                if (i.department.equals("Chemistry")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else {
                            System.out.println("Choose between 1 ,2 ,3 ,4 ,5 !!!!!!");
                        }
                    }
                    System.out.println("Enter course code Back (1)");
                    code = scanner.nextInt();
                    if (code == 1) {
                        break;
                    }
                    for (Course i : General_courses.general_courses) {
                        if (i.code == code) {
                            course_exist = true;
                            General_courses.general_courses.remove(i);
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
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 2) {
                            for (Course i : Special_courses.special_courses) {
                                if (i.department.equals("Physics")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 3) {
                            for (Course i : Special_courses.special_courses) {
                                if (i.department.equals("Computer")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else if (choice == 4) {

                            for (Course i : Special_courses.special_courses) {
                                if (i.department.equals("Chemistry")) {
                                    System.out.println("title:" + i.title + " code:" + i.code + " teacher:" + i.teacher + " capacity:" + i.capacity+" number of students:"+i.studentList.size() + " credit:" + i.credit + " day:" + i.class_time.weekday + " start:" + i.class_time.start + " end:" + i.class_time.end + " exam day:" + i.exam_time.weekday + " start:" + i.exam_time.start + " end:" + i.exam_time.end + " type:" + i.type);

                                }
                            }
                            break;
                        } else {
                            System.out.println("Choose between 1 ,2 ,3 ,4 ,5 !!!!!!");
                        }
                    }
                    System.out.println("Enter course code Back (1)");
                    code = scanner.nextInt();
                    if (code == 1) {
                        break;
                    }
                    for (Course i : Special_courses.special_courses) {
                        if (i.code == code) {
                            course_exist = true;
                            Special_courses.special_courses.remove(i);
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

    public static void add() {
        String teacher;
        String department;
        int code;
        String title;
        int capacity;
        int credit;
        Class_time class_time;
        Exam_time exam_time;
        Type type;
    }
}