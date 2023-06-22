package org.example.service;

import org.example.entity.Cart;
import org.example.entity.Product;

import java.sql.SQLException;

public interface CartItemService {
    void addProduct(Cart cart, Product product) throws SQLException;
    void deleteProduct(Product product) throws SQLException;
}
