package org.example.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Constant {

    public static final String[] ENTRANCE_MENU = {"Login", "SignUp", "Exit"};
    public static final String[] LOAN_ACCOUNT = {"Loan", "Installment", "Update", "Exit"};
    public static final String[] LOAN_TYPE = {"MORTGAGE", "EDUCATIONAL", "TUITION", "Exit"};

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
        } catch (Exception e) {
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
}
