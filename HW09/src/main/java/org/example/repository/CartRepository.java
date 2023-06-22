package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Cart;
import org.example.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface CartRepository {
    List<Product> cartDetails() throws SQLException;
    List<Cart> finalCart() throws SQLException;
}
