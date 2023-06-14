package org.example.repository;

import org.example.entity.User;

public interface UserRepo {
    void signUp(User user);

    User signIn(String username, String password);

    User isExist(String username);
}
