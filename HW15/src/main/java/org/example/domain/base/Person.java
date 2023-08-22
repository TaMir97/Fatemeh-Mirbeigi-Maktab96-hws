package org.example.domain.base;

import com.sun.istack.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.base.domain.BaseEntity;
import org.example.domain.enums.Role;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Person extends BaseEntity<Long>{

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    @Pattern(regexp="^[A-Z][a-zA-Z]* [A-Z][a-zA-Z]*$")
    private String firstname;

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    @Pattern(regexp="^[A-Z][a-zA-Z]* [A-Z][a-zA-Z]*$")
    private String lastname;

    @NotBlank(message = "Username is required")
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters")
    @Pattern(regexp = "^[0-9]+$", message = "Username must consist of numbers only")
    private String username;

    @NotBlank(message = "Username is required")
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must consist of letters and numbers only")
    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Person() {
    }


    public Person(String firstname, String lastname, String username, String password, String email, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

}