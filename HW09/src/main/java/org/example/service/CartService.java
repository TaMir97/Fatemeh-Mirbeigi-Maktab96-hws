package org.example.service;

import org.example.entity.Cart;
import org.example.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface CartService {
    List<Product> cartDetails() throws SQLException;
    List<Cart> finalCart() throws SQLException;
}
