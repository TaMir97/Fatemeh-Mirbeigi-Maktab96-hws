package org.example.entity;

import java.util.Date;

public class Book {
    private int bookId;
    private String title;
    private int releaseYear;
    private int authorId;

    public Book() {
    }

    public Book(int bookId, String title, int releaseYear, int authorId) {
        this.bookId = bookId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.authorId = authorId;
    }

    public Book(String title, int releaseYear, int authorId) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book: \n" +
                "bookId: " + bookId +
                ", title: " + title +
                ", releaseYear: " + releaseYear +
                ", authorId: " + authorId;
    }
}
