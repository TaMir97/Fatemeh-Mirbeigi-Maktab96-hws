package org.example.repository.implementation;

import org.example.base.repository.implementation.BaseRepositoryImpl;
import org.example.connection.DBConnection;
import org.example.entity.User;
import org.example.exception.UsernameExistException;
import org.example.repository.UserRepository;
import org.example.util.Constant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl
        extends BaseRepositoryImpl<Long, User>
        implements UserRepository {

    @Override
    public boolean isExistsUsername(String username) throws SQLException, UsernameExistException {
        String sql = "select user_name from " + getTableName() + " where user_name = ?";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet foundUsername = preparedStatement.executeQuery();
            if (foundUsername.next())
                throw new UsernameExistException(Constant.USER_EXISTS);
        }
        return false;
    }

    public User findUserByUsername(String username) throws SQLException {
        String sql = "select * from " + getTableName() + " where user_name = ?";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet foundUser = preparedStatement.executeQuery();
            if (foundUser.next())
                return new User(
                        foundUser.getString(2),
                        foundUser.getString(3),
                        foundUser.getString(4),
                        foundUser.getString(5),
                        foundUser.getString(6)
                );
        }
        return null;
    }

    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    public String getColumnsName() {
        return "(firstname, lastname, user_name, password, email)";
    }

    @Override
    public String getTableMainId() {
        return "userid";
    }

    @Override
    public String getUpdateQueryParams() {
        return "firstname=?, lastname=?, user_name=?, password=?, email=?";
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return "?,?,?,?,?";
    }

    @Override
    public User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, User entity) throws SQLException {
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getUsername());
        preparedStatement.setString(4, entity.getPassword());
        preparedStatement.setString(5, entity.getEmail());
    }

    @Override
    public void fillParamForStatementForUpdate(PreparedStatement preparedStatement, User entity) throws SQLException {
        fillParamForStatement(preparedStatement, entity);
        preparedStatement.setLong(6,entity.getId());
    }
}
