package org.example.ui.menu;

import org.example.domain.Employee;
import org.example.domain.StudentTakenCourse;
import org.example.domain.Teacher;
import org.example.service.StudentService;
import org.example.service.StudentTakenCourseService;
import org.example.service.TeacherService;
import org.example.ui.Printer;
import org.example.util.Constant;
import org.example.util.HibernateUtil;

import java.util.Scanner;

public class TeacherMenu {
    static Scanner input = new Scanner(System.in);

    static TeacherService teacherService = HibernateUtil.getTeacherService();
    static StudentTakenCourseService studentTakenCourseService = HibernateUtil.getStudentTakenCourseService();
    public static void run(){
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.USER_TEACHER_AND_STUDENT_MENU, "Teacher Menu");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> signIn();
                case "2" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

    private static void signIn() {
        System.out.println("Welcome to the User Login Menu");
        System.out.println("--------------------------------");

        System.out.print("Enter your username: ");
        String username = input.nextLine();

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        Teacher teacher = teacherService.signIn(username, password);

        if (teacher != null) {
            System.out.println("Login successful!");
            boolean initialMenuLoop = true;

            while (initialMenuLoop) {
                System.out.println("Enter your choice: ");
                Printer.printItem(Constant.TEACHER_ACCESS, "Teacher Menu");
                String initialInput = input.nextLine();
                switch (initialInput) {
                    case "1" -> {
                        System.out.println(teacher);
                    }
                    case "2" -> {
                        StudentTakenCourse studentTakenCourse = new StudentTakenCourse();
                        StudentTakenCourse newStudentTakenCourse = Constant.updateSingleField(studentTakenCourse);
                        studentTakenCourseService.update(newStudentTakenCourse);
                    }
                    case "3" -> {
                        System.out.println("Enter your base salary:");
                        try {
                            teacher.setBaseSalary(input.nextLong());
                            System.out.println(teacher);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case "4" -> initialMenuLoop = false;
                    default -> System.out.println("This choice does not exist.");
                }
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

}
