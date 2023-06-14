package org.example;

import org.example.UI.SignUp;
import org.example.service.BookService;

public class App {

    public static void main(String[] args) {
        BookService bookService =new BookService();

        SignUp.authorRegistration();

        SignUp.addBook();
        System.out.println(bookService.load(123));
    }





}