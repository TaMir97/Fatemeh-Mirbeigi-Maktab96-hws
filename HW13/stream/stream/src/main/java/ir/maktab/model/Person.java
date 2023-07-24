package ir.maktab.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String favoriteColor;
    private String birthDate;
    private String ipv4;
    private String ipv6;


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", favoriteColor='" + favoriteColor + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", ipv4='" + ipv4 + '\'' +
                ", ipv6='" + ipv6 + '\'' +
                '}';
    }
}
