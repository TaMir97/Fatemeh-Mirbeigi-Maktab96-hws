package org.example.base.repository.implementation;

import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;
import org.example.connection.DBConnection;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepositoryImpl<ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID, TYPE> {
    @Override
    public void save(TYPE entity) throws SQLException {
        String sql = "insert into " + getTableName() + " " + getColumnsName() + " values (" + getCountOfQuestionMarkForParams() + ")";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {

            fillParamForStatement(statement, entity);
            statement.execute();
        }

    }
    @Override
    public void update(TYPE entity) throws SQLException {
        String sql = "update " + getTableName() + " set " + getUpdateQueryParams() + " where " + getTableMainId() + "  = ?";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            fillParamForStatementForUpdate(statement, entity);
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(ID id) throws SQLException {
        String sql = "delete from " + getTableName() + " where " + getTableMainId() + " = ? ";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setLong(1, (Long) id);
            statement.executeUpdate();
        }
    }

    @Override
    public List<TYPE> findAll() throws SQLException {
        String sql = " select * from " + getTableName();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<TYPE> entities = new ArrayList<>();
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
            return entities;
        }
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        String sql = "select * from " + getTableName() + " where " + getTableMainId() + " = ? ";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setLong(1, (Long) id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return mapResultSetToEntity(resultSet);
        }
        return null;
    }



    public abstract String getTableName();

    public abstract String getColumnsName();

    public abstract String getTableMainId();

    public abstract String getUpdateQueryParams();

    public abstract String getCountOfQuestionMarkForParams();

    public abstract TYPE mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public abstract void fillParamForStatement(PreparedStatement preparedStatement, TYPE entity) throws SQLException;
    public abstract void fillParamForStatementForUpdate(PreparedStatement preparedStatement, TYPE entity) throws SQLException;

}
