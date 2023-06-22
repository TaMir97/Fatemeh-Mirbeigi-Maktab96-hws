package org.example.repository.implementation;

import org.example.base.repository.implementation.BaseRepositoryImpl;
import org.example.connection.DBConnection;
import org.example.entity.Cart;
import org.example.entity.Product;
import org.example.repository.CartRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartRepositoryImpl
        extends BaseRepositoryImpl<Long, Cart>
        implements CartRepository {
    @Override
    public List<Product> cartDetails(Cart cart) throws SQLException {
        String sql = """
                select category_name, type_name, count(products.productid) as total_items, sum(price)
                from products
                         join cart_items ci on ci.productid = products.productid
                         join cart c on ci.cartid = ?
                group by category_name, type_name""";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, cart.getId());
            ResultSet cartProducts = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (cartProducts.next()) {
                products.add(new Product(cartProducts.getString(2),
                        cartProducts.getString(3),
                        cartProducts.getInt(5),
                        cartProducts.getLong(4)));
            }
            return products;

        }
    }

    @Override
    public List<Cart> finalCart(Cart cart) throws SQLException {
        String sql = """
                select userid, count(ci.productID) AS total_products, sum(price)
                                                 from products
                                                          join cart_items ci on products.productid = ci.productid
                                                          join cart c on ci.cartid = ?
                                                 group by c.cartID;""";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, cart.getId());
            ResultSet finalCart = preparedStatement.executeQuery();
            List<Cart> carts = new ArrayList<>();
            while (finalCart.next()) {
                carts.add(new Cart(finalCart.getLong(2),
                        finalCart.getInt(3),
                        finalCart.getLong(4)));
            }
            return carts;
        }
    }


    @Override
    public String getTableName() {
        return "cart";
    }

    @Override
    public String getColumnsName() {
        return "(userid, paycheck, total_items)";
    }

    @Override
    public String getTableMainId() {
        return "cartid";
    }

    @Override
    public String getUpdateQueryParams() {
        return "userid=? , paycheck=? , total_items=? ";
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return "(?, ?, ?)";
    }

    @Override
    public Cart mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Cart(resultSet.getLong(2),
                resultSet.getInt(3),
                resultSet.getLong(4));
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Cart entity) throws SQLException {
        preparedStatement.setLong(1, entity.getUserID());
        preparedStatement.setLong(2, entity.getPaycheck());
        preparedStatement.setInt(3, entity.getTotalItems());
    }

    @Override
    public void fillParamForStatementForUpdate(PreparedStatement preparedStatement, Cart entity) throws SQLException {
        fillParamForStatement(preparedStatement, entity);
        preparedStatement.setLong(4, entity.getId());

    }
}
