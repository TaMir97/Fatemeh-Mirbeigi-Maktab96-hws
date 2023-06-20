package org.example.UI;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;

import java.util.Scanner;

public class SignUp {
    static Scanner input = new Scanner(System.in);
    static AuthorService authorService = new AuthorService();
    static BookService bookService = new BookService();
    public static void authorRegistration() {
        Author author = new Author();

        System.out.println("Enter Your First Name");
        author.setFirstname(input.nextLine());

        System.out.println("Enter Your Last Name");
        author.setLastname(input.nextLine());

        System.out.println("Enter Your Age");
        author.setAge(input.nextInt());

        System.out.println("Your ID is: " + authorService.register(author));
    }

    public static void addBook() {
        System.out.println("Enter your authorization ID:");
        int authorId = input.nextInt();
        input.nextLine();

        System.out.println("How many books do you have?");
        int numberOfBooks = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numberOfBooks; i++) {
            Book book = new Book();
            System.out.println("Enter the title of your book: ");
            book.setTitle(input.nextLine());
            System.out.println("Enter the release year: ");
            book.setReleaseYear(input.nextInt());
            input.nextLine();
            book.setAuthorId(authorId);
            bookService.addBook(book);
        }
    }
}
