package org.example.service.implementation;

import org.example.entity.Cart;
import org.example.entity.Product;
import org.example.repository.CartItemRepository;
import org.example.repository.ProductRepository;
import org.example.service.CartItemService;
import org.example.service.ProductService;

import java.sql.SQLException;

public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;

    public CartItemServiceImpl(CartItemRepository cartItemRepository,ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    @Override
    public void addProduct(Cart cart, Product product) throws SQLException {
        cartItemRepository.addProduct(cart,product);
        productService.updateAvailabilityAdd(product,product.getAvailability());
    }

    @Override
    public void deleteProduct(Product product) throws SQLException {
        cartItemRepository.deleteProduct(product);
        productService.updateAvailabilityDelete(product, product.getAvailability());

    }
}
