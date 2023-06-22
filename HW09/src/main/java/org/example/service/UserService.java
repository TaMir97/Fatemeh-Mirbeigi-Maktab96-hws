package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.User;
import org.example.exception.UsernameExistException;

import java.sql.SQLException;

public interface UserService extends BaseService<Long, User> {
    boolean isExistsUsername(String username) throws SQLException, UsernameExistException;

    User signIn(String username, String password) throws Exception;
}
