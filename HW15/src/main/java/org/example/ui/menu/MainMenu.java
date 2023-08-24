package org.example.ui.menu;

import org.example.ui.Printer;
import org.example.util.Constant;

import java.util.Scanner;

public class MainMenu {
    static Scanner input = new Scanner(System.in);

    public static void run() {
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.ENTRANCE_MENU, "Entrance Menu");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> EmployeeMenu.run();
                case "2" -> TeacherMenu.run();
                case "3" -> StudentMenu.run();
                case "4" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

}
