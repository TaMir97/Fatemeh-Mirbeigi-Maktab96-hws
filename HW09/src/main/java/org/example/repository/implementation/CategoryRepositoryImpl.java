package org.example.repository.implementation;

import org.example.entity.Categories;
import org.example.repository.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final Connection connection;

    public CategoryRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCategory() {
        String insertQuery = "insert into categories (category_name) values (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            for (Categories category : Categories.values()) {
                preparedStatement.setString(1, category.name());
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
