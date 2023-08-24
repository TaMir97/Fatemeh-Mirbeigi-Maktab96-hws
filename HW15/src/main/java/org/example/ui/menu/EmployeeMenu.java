package org.example.ui.menu;

import org.example.domain.*;
import org.example.domain.enums.Season;
import org.example.domain.enums.TeacherLevel;
import org.example.service.*;
import org.example.ui.Printer;
import org.example.util.Constant;
import org.example.util.HibernateUtil;

import java.lang.reflect.Field;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
    static Scanner input = new Scanner(System.in);

    static DepartmentService departmentService = HibernateUtil.getDepartmentService();
    static EmployeeService employeeService = HibernateUtil.getEmployeeService();
    static TeacherService teacherService = HibernateUtil.getTeacherService();
    static StudentService studentService = HibernateUtil.getStudentService();
    static CourseService courseService = HibernateUtil.getCourseService();
    static ReleasedCourseService releasedCourseService = HibernateUtil.getReleasedCourseService();
    static StudentTakenCourseService studentTakenCourseService = HibernateUtil.getStudentTakenCourseService();
    static SemesterService semesterService = HibernateUtil.getSemesterService();

    public static void run() {
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.EMPLOYEE_MENU, "Employee Menu");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> accessEmployee();
                case "2" -> teacherManipulation();
                case "3" -> studentManipulation();
                case "4" -> courseManipulation();
                case "5" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

    private static void accessEmployee() {
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.USER_EMPLOYEE_MENU, "Private Employee Menu");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> employeeSignIn();
                case "2" -> employeeSignUp();
                case "3" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

    private static void employeeSignIn() {
        System.out.println("Welcome to the User Login Menu");
        System.out.println("--------------------------------");

        System.out.print("Enter your username: ");
        String username = input.nextLine();

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        Employee employee = employeeService.signIn(username, password);

        if (employee != null) {
            System.out.println("Login successful!");
            System.out.println(employee.getSalary());
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }

    }

    private static void employeeSignUp() {
        System.out.println("Enter Firstname: ");
        String firstname = input.nextLine();
        System.out.println("Enter Lastname: ");
        String lastname = input.nextLine();
        System.out.println("Enter Username: ");
        String username = input.nextLine();
        System.out.println("Enter Password: ");
        String password = input.nextLine();
        System.out.println("Enter email: ");
        String email = input.nextLine();
        System.out.println("Enter the Base Salary: ");
        long baseSalary = 0L;
        try {
            baseSalary = input.nextLong();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Employee newEmployee = employeeService.signUp(firstname, lastname, username, password, email, baseSalary);
        System.out.println("The Employee has been signed up:");
        System.out.println(newEmployee);

    }

    private static void teacherManipulation() {
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.TEACHER_MANIPULATION, "Teacher Database Manipulation Menu By Employee");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> {
                    System.out.println("Enter Firstname: ");
                    String firstname = input.nextLine();
                    System.out.println("Enter Lastname: ");
                    String lastname = input.nextLine();
                    System.out.println("Enter Username: ");
                    String username = input.nextLine();
                    System.out.println("Enter Password: ");
                    String password = input.nextLine();
                    System.out.println("Enter email: ");
                    String email = input.nextLine();
                    System.out.println("Enter the Base Salary: ");
                    long baseSalary;
                    try {
                        baseSalary = input.nextLong();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    String[] level = new String[2];
                    for (int i = 0; i < 2; i++)
                        level[i] = String.valueOf(Arrays.asList(TeacherLevel.values()).get(i));
                    Printer.printItem(level, "Choose a Level:");
                    TeacherLevel teacherLevel;
                    try {
                        teacherLevel = TeacherLevel.values()[input.nextInt() - 1];
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    Department department = new Department();
                    System.out.println("Enter the Department Title");
                    String title = input.nextLine();
                    department.setDepartmentName(title);
                    departmentService.save(department);

                    Teacher newTeacher = teacherService.signUp(firstname, lastname, username, password, email, baseSalary, teacherLevel, department);
                    System.out.println("The Teacher has been signed up: ");
                    System.out.println(newTeacher);
                }
                case "2" -> {
                    Teacher teacher = new Teacher();
                    Teacher newTeacher = Constant.updateSingleField(teacher);
                    teacherService.update(newTeacher);
                }
                case "3" -> {
                    List<Teacher> records = teacherService.showAll().stream().toList();

                    System.out.println("Available records to delete:");
                    for (int i = 0; i < records.size(); i++) {
                        System.out.println((i + 1) + ". " + records.get(i));
                    }

                    System.out.print("Select the record to delete (enter the number): ");
                    int selectedRecordIndex = 0;
                    try {
                        selectedRecordIndex = Integer.parseInt(input.nextLine());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    if (selectedRecordIndex < 1 || selectedRecordIndex > records.size()) {
                        System.out.println("Invalid record selection.");
                        return;
                    }

                    Teacher selectedRecord = records.get(selectedRecordIndex - 1);
                    teacherService.deleteById(selectedRecord.getId());

                    System.out.println("Record deleted successfully.");

                }
                case "4" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }

    }

    private static void studentManipulation() {
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.STUDENT_MANIPULATION, "Student Database Manipulation Menu By Employee");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> {

                    System.out.println("Enter Firstname: ");
                    String firstname = input.nextLine();
                    System.out.println("Enter Lastname: ");
                    String lastname = input.nextLine();
                    System.out.println("Enter Username: ");
                    String username = input.nextLine();
                    System.out.println("Enter Password: ");
                    String password = input.nextLine();
                    System.out.println("Enter email: ");
                    String email = input.nextLine();

                    System.out.println("Enter the Department Title: ");
                    String departmentTitle = input.nextLine();
                    Department department = new Department(departmentTitle);
                    departmentService.save(department);

                    Student newStudent = studentService.signUp(firstname, lastname, username, password, email, departmentTitle);
                    System.out.println("The Student has been signed up:");
                    System.out.println(newStudent);
                }
                case "2" -> {
                    Student student = new Student();
                    Student newStudent = Constant.updateSingleField(student);
                    studentService.update(newStudent);
                }
                case "3" -> {
                    List<Student> records = studentService.showAll().stream().toList();

                    System.out.println("Available records to delete:");
                    for (int i = 0; i < records.size(); i++) {
                        System.out.println((i + 1) + ". " + records.get(i));
                    }

                    System.out.print("Select the record to delete (enter the number): ");
                    int selectedRecordIndex = 0;
                    try {

                        selectedRecordIndex = Integer.parseInt(input.nextLine());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    if (selectedRecordIndex < 1 || selectedRecordIndex > records.size()) {
                        System.out.println("Invalid record selection.");
                        return;
                    }

                    Student selectedRecord = records.get(selectedRecordIndex - 1);
                    studentService.deleteById(selectedRecord.getId());

                    System.out.println("Record deleted successfully.");

                }
                case "4" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

    private static void courseManipulation() {
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.ACCESS_COURSE, "Accessed Course Menu");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> mainCourses();
                case "2" -> releasedCourses();
                case "3" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }


    private static void mainCourses() {
        courseService.showAll().forEach(System.out::println);

        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.MAIN_COURSES_MENU, "Accessed Course Menu: ");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> saveNewCourse();
                case "2" -> deleteExistingCourse();
                case "3" -> updateExistingCourse();
                case "4" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

    private static void saveNewCourse() {
        System.out.println("Enter the Course title: ");
        String title = input.nextLine();
        System.out.println("Enter the Course Credit: ");
        int credit = 0;
        try {
            credit = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter the Department Title: ");
        String departmentTitle = input.nextLine();
        Department courseDepartment = new Department(departmentTitle);
        departmentService.save(courseDepartment);

        Course newCourse = new Course(title, credit, courseDepartment);

        courseService.save(newCourse);

    }

    private static void deleteExistingCourse() {
        List<Course> records = courseService.showAll().stream().toList();

        System.out.println("Available records to delete:");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i));
        }

        System.out.print("Select the record to delete (enter the number): ");
        int selectedRecordIndex = 0;
        try {
            selectedRecordIndex = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (selectedRecordIndex < 1 || selectedRecordIndex > records.size()) {
            System.out.println("Invalid record selection.");
            return;
        }

        Course selectedRecord = records.get(selectedRecordIndex - 1);
        courseService.deleteById(selectedRecord.getId());

        System.out.println("Record deleted successfully.");
    }

    private static void updateExistingCourse() {
        Course course = new Course();
        Course newCourse = Constant.updateSingleField(course);
        courseService.update(newCourse);
    }

    private static void releasedCourses() {
        releasedCourseService.showAll().forEach(System.out::println);
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.RELEASED_COURSES_MENU, "Accessed Released Course Menu: ");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> saveNewReleasedCourse();
                case "2" -> deleteExistingReleasedCourse();
                case "3" -> updateExistingReleasedCourse();
                case "4" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

    private static void saveNewReleasedCourse() {
        Semester semester = createSemester();


        List<Teacher> teacherList = teacherService.showAll().stream().toList();
        List<Course> courseList = courseService.showAll().stream().toList();

        System.out.println("Available Teachers:");
        for (int i = 0; i < teacherList.size(); i++) {
            System.out.println((i + 1) + ". " + teacherList.get(i));
        }
        System.out.print("Select a teacher (enter the number): ");
        int selectedTeacherIndex = Integer.parseInt(input.nextLine());

        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println((i + 1) + ". " + courseList.get(i));
        }
        System.out.print("Select a course (enter the number): ");
        int selectedCourseIndex = Integer.parseInt(input.nextLine());


        ReleasedCourse newReleasedCourse = new ReleasedCourse();

        newReleasedCourse.setTeacher(teacherList.get(selectedTeacherIndex - 1));
        newReleasedCourse.setCourse(courseList.get(selectedCourseIndex - 1));
        newReleasedCourse.setSemester(semester);

        releasedCourseService.save(newReleasedCourse);
    }

    private static void deleteExistingReleasedCourse() {
        List<ReleasedCourse> records = releasedCourseService.showAll().stream().toList();

        System.out.println("Available records to delete:");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i));
        }

        System.out.print("Select the record to delete (enter the number): ");
        int selectedRecordIndex = 0;
        try {
            selectedRecordIndex = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (selectedRecordIndex < 1 || selectedRecordIndex > records.size()) {
            System.out.println("Invalid record selection.");
            return;
        }

        ReleasedCourse selectedRecord = records.get(selectedRecordIndex - 1);
        courseService.deleteById(selectedRecord.getId());

        System.out.println("Record deleted successfully.");
    }

    private static void updateExistingReleasedCourse() {
        ReleasedCourse releasedCourse = new ReleasedCourse();
        ReleasedCourse newReleasedCourse = Constant.updateSingleField(releasedCourse);
        releasedCourseService.update(newReleasedCourse);
    }

    private static Semester createSemester() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Select a season:");
        Season[] seasons = Season.values();
        for (int i = 0; i < seasons.length; i++) {
            System.out.println((i + 1) + ". " + seasons[i]);
        }
        System.out.print("Enter the number for the chosen season: ");
        int selectedSeasonIndex = Integer.parseInt(scanner.nextLine());


        if (selectedSeasonIndex < 1 || selectedSeasonIndex > seasons.length) {
            System.out.println("Invalid season selection.");
            return null;
        }

        Season selectedSeason = seasons[selectedSeasonIndex - 1];

        Semester semester = new Semester();
        semester.setSeason(selectedSeason);

        return semester;
    }

}
