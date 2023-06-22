package org.example.service.implementation;

import org.example.base.service.implementation.BaseServiceImpl;
import org.example.entity.User;
import org.example.exception.BadCredentialException;
import org.example.exception.UserNotFoundException;
import org.example.exception.UsernameExistException;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.util.Constant;

import java.sql.SQLException;

public class UserServiceImpl
        extends BaseServiceImpl<Long, User, UserRepository>
        implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public boolean isExistsUsername(String username) throws SQLException, UsernameExistException {
        return repository.isExistsUsername(username);
    }

    @Override
    public User signIn(String username, String password) throws Exception {
        User foundUser = findUserByUsername(username);
        if (foundUser != null) {
            if (username.equals(foundUser.getUsername()) &&
                    password.equals(foundUser.getPassword()))
                return foundUser;
            else
                throw new BadCredentialException(Constant.BAD_CREDENTIAL);
        }
        throw new UserNotFoundException(Constant.USER_NOT_FOUND);
    }
    public User findUserByUsername(String username) throws SQLException {
        return repository.findUserByUsername(username);
    }

}
