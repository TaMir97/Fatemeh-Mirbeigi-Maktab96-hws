package org.example.service.implementation;

import org.example.entity.Cart;
import org.example.entity.Product;
import org.example.repository.CartRepository;
import org.example.service.CartService;

import java.sql.SQLException;
import java.util.List;

public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Product> cartDetails() throws SQLException {
        return cartRepository.cartDetails();
    }

    @Override
    public List<Cart> finalCart() throws SQLException {
        return cartRepository.finalCart();
    }
}
