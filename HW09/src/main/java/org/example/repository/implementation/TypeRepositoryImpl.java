package org.example.repository.implementation;

import org.example.entity.Categories;
import org.example.entity.Types;
import org.example.repository.TypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TypeRepositoryImpl implements TypeRepository {
    private final Connection connection;

    public TypeRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addType() {
        String insertQuery = """
                                insert into "types" (type_name) values (?)
                                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            for (Types types : Types.values()) {
                preparedStatement.setString(1, types.name());
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
