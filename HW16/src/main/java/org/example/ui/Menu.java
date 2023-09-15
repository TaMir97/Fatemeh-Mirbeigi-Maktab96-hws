package org.example.ui;

import org.example.ui.menu.LoanAccountMenu;
import org.example.util.Constant;

import java.util.Scanner;

public class Menu {

    static Scanner input = new Scanner(System.in);

    public static void run() {
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            System.out.println("Enter your choice: ");
            Printer.printItem(Constant.ENTRANCE_MENU, "Entrance Menu");
            String initialInput = input.nextLine();
            switch (initialInput) {
                case "1" -> LoanAccountMenu.login();
                case "2" -> LoanAccountMenu.signUp();
                case "3" -> initialMenuLoop = false;
                default -> System.out.println("This choice does not exist.");
            }
        }
    }

}
