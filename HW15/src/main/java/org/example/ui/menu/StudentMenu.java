package org.example.ui.menu;

import org.example.domain.ReleasedCourse;
import org.example.domain.Student;
import org.example.domain.StudentTakenCourse;
import org.example.domain.Teacher;
import org.example.service.ReleasedCourseService;
import org.example.service.StudentService;
import org.example.service.StudentTakenCourseService;
import org.example.service.TeacherService;
import org.example.ui.Printer;
import org.example.util.Constant;
import org.example.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentMenu {
    static Scanner input = new Scanner(System.in);

    static StudentService studentService = HibernateUtil.getStudentService();

    static ReleasedCourseService releasedCourseService = HibernateUtil.getReleasedCourseService();
    static StudentTakenCourseService studentTakenCourseService = HibernateUtil.getStudentTakenCourseService();
    public static void run(){
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.USER_TEACHER_AND_STUDENT_MENU, "Student Menu");
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

        Student student = studentService.signIn(username, password);

        if (student != null) {
            System.out.println("Login successful!");
            boolean initialMenuLoop = true;

            while (initialMenuLoop) {
                System.out.println("Enter your choice: ");
                Printer.printItem(Constant.STUDENT_ACCESS, "Teacher Menu");
                String initialInput = input.nextLine();
                switch (initialInput) {
                    case "1" -> {
                        System.out.println(student);
                    }
                    case "2" -> {
                        List<ReleasedCourse> releasedCourseList = releasedCourseService.showAll().stream().toList();
                        releasedCourseList.forEach(System.out::println);
                    }
                    case "3" -> {
                        List<>

                        List<Student> highGPA = studentService.studentsWithHighGPA();
                        Optional<Student> foundObject = highGPA.stream()
                                .filter(item -> item.equals(student))
                                .findFirst();

                        if (foundObject.isPresent()) {
                            // Object found
                        }

                        List<Student> lowGPA = studentService.studentsWithLowGPA();
                        Optional<Student> found = lowGPA.stream()
                                .filter(item -> item.equals(student))
                                .findFirst();

                        if (found.isPresent()) {
                            // Object found
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
