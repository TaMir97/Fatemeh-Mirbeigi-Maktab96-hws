package org.example.repository.implementation;

import org.example.connection.DBConnection;
import org.example.entity.Cart;
import org.example.entity.Product;
import org.example.repository.CartItemRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartItemRepositoryImpl implements CartItemRepository {

    @Override
    public void addProduct(Cart cart, Product product)  throws SQLException {
        String sql = """
                insert into cart_items(cartid, productid) values(?,?)
                """;
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)){
            preparedStatement.setLong(1,cart.getId());
            preparedStatement.setLong(2,product.getId());
            preparedStatement.execute();
        }
    }

    @Override
    public void deleteProduct(Product product)  throws SQLException{
        String sql = """
               delete from cart_items
               where productid = ?
                """;
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)){
            preparedStatement.setLong(1,product.getId());
            preparedStatement.executeUpdate();
        }

    }
}
