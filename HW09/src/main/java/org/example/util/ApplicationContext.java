package org.example.util;

import org.example.connection.DBConnection;
import org.example.repository.*;
import org.example.repository.implementation.*;
import org.example.service.*;
import org.example.service.implementation.*;

import java.sql.Connection;

public class ApplicationContext {
    private static final Connection connection;
    private static final UserRepository userRepository;
    private static final UserService userService;
    private static final ProductRepository productRepository;
    private static final ProductService productService;
    private static final TypeRepository typeRepository;
    private static final TypeService typeService;
    private static final CategoryRepository categoryRepository;
    private static final CategoryService categoryService;
    private static final CartItemRepository cartItemRepository;
    private static final CartItemService cartItemService;
    private static final CartRepository cartRepository;
    private static final CartService cartService;

    static {
        connection = DBConnection.getConnection();
        userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl(userRepository);
        productRepository = new ProductRepositoryImpl();
        productService = new ProductServiceImpl(productRepository);
        typeRepository = new TypeRepositoryImpl(connection);
        typeService = new TypeServiceImpl(typeRepository);
        categoryRepository = new CategoryRepositoryImpl(connection);
        categoryService = new CategoryServiceImpl(categoryRepository);
        cartItemRepository = new CartItemRepositoryImpl();
        cartItemService = new CartServiceImpl(cartItemRepository);
        cartRepository = new CartRepositoryImpl();
        cartService = new CartServiceImpl(cartRepository);


    }

    public static UserService getUserService(){
        return userService;
    }
    public static ProductService getProductService(){
        return productService;
    }
    public static TypeService getTypeService(){
        return typeService;
    }
    public static CategoryService getCategoryService(){
        return categoryService;
    }
    public static CartService getCartService(){
        return cartService;
    }
    public static CartItemService getCartItemService(){
        return cartItemService;
    }


}
