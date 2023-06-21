package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.User;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<Long, User> {
    boolean isExistsUsername(String username) throws SQLException;

    User findUserByUsername(String username) throws SQLException;

}
