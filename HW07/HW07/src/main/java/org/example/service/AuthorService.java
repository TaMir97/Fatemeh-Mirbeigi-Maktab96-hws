package org.example.service;

import org.example.entity.Author;
import org.example.repository.implement.AuthorRepository;

public class AuthorService {
    AuthorRepository authorRepository = new AuthorRepository();


    public int register(Author author) {
        Author newAuthor = new Author(author.getFirstname(), author.getLastname(), author.getAge());
        authorRepository.save(newAuthor);
        return newAuthor.getAuthorId();
    }

    public void load(int authorId) {
        System.out.println(authorRepository.load(authorId));
    }

}
