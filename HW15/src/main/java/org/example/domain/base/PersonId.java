package org.example.domain.base;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@Embeddable
public abstract class PersonId implements Serializable {

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    @Pattern(regexp="^[a-zA-Z]+$", message = "FirstName must consist of letters only")
    private String firstname;

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    @Pattern(regexp="^[a-zA-Z]*$", message = "LastName must consist of letters only")
    private String lastname;

    @NotBlank(message = "Username is required")
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters")
    @Pattern(regexp = "^[0-9]+$", message = "Username must consist of numbers only")
    private String username;

    @NotBlank(message = "Username is required")
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must consist of letters and numbers only")
    private String password;

    @Email(message = "Email should be valid")
    private String email;


    public PersonId() {
    }


    public PersonId(String firstname, String lastname, String username, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
