package org.example.repository.implementation;

import org.example.base.repository.implementation.BaseRepositoryImpl;
import org.example.connection.DBConnection;
import org.example.entity.Product;
import org.example.exception.NotDefinedCategory;
import org.example.exception.NotDefinedType;
import org.example.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl
        extends BaseRepositoryImpl<Long, Product>
        implements ProductRepository {

    @Override
    public List<Product> findByCategory(String category) throws SQLException, NotDefinedCategory {
        String sql = "select * from " + getTableName() + " where category_name = ?";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, category);
            ResultSet foundProducts = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (foundProducts.next()) {
                products.add(new Product(category,
                        foundProducts.getString(3),
                        foundProducts.getInt(5),
                        foundProducts.getLong(4)));
            }
            return products;
        }
    }

    @Override
    public List<Product> findByType(String type) throws SQLException, NotDefinedType {
        String sql = "select * from " + getTableName() + " where type_name = ?";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, type);
            ResultSet foundProducts = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (foundProducts.next()) {
                products.add(new Product(foundProducts.getString(2),
                        type,
                        foundProducts.getInt(5),
                        foundProducts.getLong(4)));
            }
            return products;
        }
    }

    @Override
    public void updateAvailability(Product product, int chosenItems) throws SQLException {
        String sql = "update products set availability = ? where productid = ?";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, product.getAvailability() - chosenItems);
            preparedStatement.setLong(2, product.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public String getTableName() {
        return "products";
    }

    @Override
    public String getColumnsName() {
        return "(category_name, type_name, price, availability)";
    }

    @Override
    public String getTableMainId() {
        return "productid";
    }

    @Override
    public String getUpdateQueryParams() {
        return "category_name=?, type_name=?, price=?, availability=?";
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return " ?, ?, ?, ?";
    }

    @Override
    public Product mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(5),
                resultSet.getLong(4));
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Product entity) throws SQLException {
        preparedStatement.setString(1, entity.getCategoryName());
        preparedStatement.setString(2, entity.getTypeName());
        preparedStatement.setLong(3, entity.getPrice());
        preparedStatement.setInt(4, entity.getAvailability());
    }

    @Override
    public void fillParamForStatementForUpdate(PreparedStatement preparedStatement, Product entity) throws SQLException {
        fillParamForStatement(preparedStatement, entity);
        preparedStatement.setLong(5, entity.getId());
    }


}
