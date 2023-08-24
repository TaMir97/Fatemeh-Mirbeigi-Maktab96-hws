package org.example.util;

import org.example.domain.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Constant {

    public static final String[] ENTRANCE_MENU = {"Employee", "Teacher", "Student", "Exit"};
    public static final String[] EMPLOYEE_MENU = {"Access Employee", "Teacher Manipulation", "Student Manipulation", "Course Manipulation", "Exit"};
    public static final String[] USER_EMPLOYEE_MENU = {"signIn", "signUp", "Exit"};
    public static final String[] TEACHER_MANIPULATION = {"Add new Teacher", "Update existing Teacher", "Delete existing Teacher", "Exit"};
    public static final String[] STUDENT_MANIPULATION = {"Add new Student", "Update existing Student", "Delete existing Student", "Exit"};
    public static final String[] ACCESS_COURSE = {"Display and Access Main Courses",
            "Display and Access Released Courses",
            "Exit"};
    public static final String[] MAIN_COURSES_MENU = {"Add new Course",
            "Delete Existing Course",
            "Update Existing Course",
            "Exit"};
    public static final String[] RELEASED_COURSES_MENU = {"Add Released Course",
            "Delete Existing Released Course",
            "Update Existing Released Course",
            "Exit"};
    public static final String[] editProfile = {"change username", "change email", "change name", "main menu"};
    public static final String[] showDirect = {"show all", "delete all", "delete by number", "main menu"};
    public static final String[] tweetOption = {"like", "comment", "show comments"};

    public static <T> T updateSingleField(T entity) {
        Scanner scanner = new Scanner(System.in);

        Field[] fields = entity.getClass().getDeclaredFields();
        System.out.println("Available fields to update:");
        for (int i = 0; i < fields.length; i++) {
            System.out.println((i + 1) + ". " + fields[i].getName());
        }

        System.out.print("Select the field to update: ");
        int selectedFieldIndex = 0;
        try {
            selectedFieldIndex = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if (selectedFieldIndex < 1 || selectedFieldIndex > fields.length) {
            System.out.println("Invalid field selection.");
            return entity;
        }

        Field selectedField = fields[selectedFieldIndex - 1];
        selectedField.setAccessible(true);

        System.out.print("Enter new value for " + selectedField.getName() + ": ");
        String newValue = scanner.nextLine();

        try {
            if (selectedField.getType().isEnum()) {
                Enum<?>[] enumConstants = (Enum<?>[]) selectedField.getType().getEnumConstants();
                Enum<?> enumValue = Enum.valueOf((Class<Enum>) selectedField.getType(), newValue);
                selectedField.set(entity, enumValue);
            } else {
                selectedField.set(entity, selectedField.getType().getConstructor(String.class).newInstance(newValue));
            }
            System.out.println("Field updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to update field.");
        }

        return entity;
    }


    public <T,S> void displayAndDeleteRecords(Class<T> entityClass, S entityService) {
        Scanner scanner = new Scanner(System.in);

        // Fetch all records of the specified entity type

    }

}
