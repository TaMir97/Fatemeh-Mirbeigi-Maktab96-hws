package org.example.ui.menu;

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
    static StudentService studentService = HibernateUtil.getStudentService();
    static StudentTakenCourseService studentTakenCourseService = HibernateUtil.getStudentTakenCourseService();
    public static void run(){
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.USER_TEACHER_MENU, "Teacher Menu");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> signIn();
                case "2" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }


    }

    private static void signIn() {
    }
}
