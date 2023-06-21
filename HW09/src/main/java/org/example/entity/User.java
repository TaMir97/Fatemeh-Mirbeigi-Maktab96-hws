package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User extends BaseEntity<Long> {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

}
