package org.example.log4j.base.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    private String firstname;
    private String lastname;
    private Date birthdate;

    public Person() {
    }

    public Person(Long personId, String firstname, String lastname, Date birthdate) {
        this.personId = personId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
