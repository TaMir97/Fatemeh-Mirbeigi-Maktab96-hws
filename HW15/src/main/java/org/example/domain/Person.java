package org.example.domain;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.base.domain.BaseEntity;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class Person extends BaseEntity<Long>  {

    @Pattern(regexp="^[a-zA-Z]+$", message = "FirstName must consist of letters only")
    private String firstname;

    @Pattern(regexp="^[a-zA-Z]+$", message = "LastName must consist of letters only")
    private String lastname;

    @Pattern(regexp = "^[0-9]+$", message = "Username must consist of numbers only")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must consist of letters and numbers only")
    private String password;

    @Email(message = "Email should be valid")
    private String email;


    public Person() {
    }

    public Person(String firstname, String lastname, String username, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



