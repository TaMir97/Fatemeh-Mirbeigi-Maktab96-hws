package org.example.ui.menuHandler;

import org.example.entity.User;
import org.example.service.UserService;
import org.example.ui.Printer;
import org.example.util.ApplicationContext;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserActivity {
    static Scanner input = new Scanner(System.in);
    private static final UserService userService = ApplicationContext.getUserService();

    public static void signup() throws SQLException {
        User user = new User();

        System.out.println("Enter Your FirstName: ");
        try {
            user.setFirstName(input.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("wrong format");
        }

        System.out.println("Enter Your LastName: ");
        try {
            user.setLastName(input.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("wrong format");
        }
        
        System.out.println("Enter Your Username: ");
        try {
            user.setUsername(input.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("wrong format");
        }
        

        System.out.println("Enter Your Password: ");
        try {
            user.setPassword(input.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("wrong format");
        }

        System.out.println("Enter Your Email: ");
        try {
            user.setEmail(input.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("wrong format");
        }

        userService.save(user);

        Printer.printMsg("Successfully signed up.");
    }

    public static User login() throws Exception {
        String username = null;
        String password = null;
        System.out.println("Enter Your Username: ");
        try {
            username = input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("wrong format");
        }
        

        System.out.println("Enter Your Password: ");
        try {
            password = input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("wrong format");
        }

        return userService.signIn(username, password);
    }

}
