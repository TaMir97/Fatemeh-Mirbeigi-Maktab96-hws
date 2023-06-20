package org.example.entity;

public class Author {
    private int authorId;
    private String firstname;
    private String lastname;
    private int age;

    public Author() {
    }

    public Author(int authorId, String firstname, String lastname, int age) {
        this.authorId = authorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Author(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author: \n" +
                "authorId: " + authorId +
                ", firstname: " + firstname +
                ", lastname: " + lastname +
                ", age: " + age;
    }
}
