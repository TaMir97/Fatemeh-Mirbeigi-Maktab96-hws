package org.example.service;

import org.example.entity.Book;
import org.example.repository.implement.BookRepository;

public class BookService {
    BookRepository bookRepository = new BookRepository();

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Book book){
        bookRepository.deleteBook(book);
    }

    public Book load(int bookId) {
       return bookRepository.load(bookId);
    }


}
