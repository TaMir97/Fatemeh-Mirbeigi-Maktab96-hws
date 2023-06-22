package org.example.ui;

import org.example.entity.Cart;
import org.example.entity.Categories;
import org.example.entity.Product;
import org.example.entity.Types;
import org.example.service.CartService;
import org.example.service.CategoryService;
import org.example.service.ProductService;
import org.example.service.TypeService;
import org.example.ui.menuHandler.UserActivity;
import org.example.util.ApplicationContext;
import org.example.util.Constant;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static Scanner input = new Scanner(System.in);

    protected static void initializer() throws SQLException {
        try {
            CategoryService categoryService = ApplicationContext.getCategoryService();
            categoryService.addCategory();
        } catch (RuntimeException e) {
            System.out.println(" ");
        }
        try {
            TypeService typeService = ApplicationContext.getTypeService();
            typeService.addType();
        } catch (RuntimeException e) {
            System.out.println(" ");
        }

        ProductService productService = ApplicationContext.getProductService();
        productService.save(new Product(Categories.ELECTRONICS.toString(), Types.RADIO.toString(), 100, 50_000L));
        productService.save(new Product(Categories.ELECTRONICS.toString(), Types.TV.toString(), 100, 100_000L));
        productService.save(new Product(Categories.SHOES.toString(), Types.FORMAL.toString(), 100, 10_000L));
        productService.save(new Product(Categories.SHOES.toString(), Types.SPORTS.toString(), 100, 20_000L));
    }

    public static void run() throws Exception {
        try {
            initializer();
        } catch (SQLException e) {
            System.out.println(" ");
        }

        int runItem;
        boolean breakLoop = false;

        while (!breakLoop) {
            Printer.printMenu(Constant.RUN_ITEMS);
            runItem = input.nextInt();
            input.nextLine();

            switch (runItem) {
                case 1 -> {
                    UserActivity.signup();
                }
                case 2 -> {
                    if (UserActivity.login() != null) {
                        Printer.printMsg(UserActivity.login() + Constant.ALERT_USER_LOGIN);
                        String loggedIn = input.nextLine();
                        shopping(loggedIn);
                        CartService cartService = ApplicationContext.getCartService();
                        List<Product> carts = cartService.cartDetails();
                        for(Product c :carts){
                            System.out.println(c);
                        }
                    }
                }
                case 3 -> {
                    CartService cartService = ApplicationContext.getCartService();
                    List<Cart> carts = cartService.finalCart();
                    for(Cart c :carts){
                        System.out.println(c);
                    }
                    breakLoop = true;
                    Printer.printMsg(Constant.ALERT_EXIT);
                }

                default -> Printer.printMsg(Constant.ALERT_CHOICE);
            }
        }

    }

    private static void shopping(String access) throws SQLException {
        if (access.equalsIgnoreCase("y")) {
            int databaseItem;
            boolean breakLoop = false;

            while (!breakLoop) {
                Printer.printMenu(Constant.SHOPPING_ITEMS);
                databaseItem = input.nextInt();

                switch (databaseItem) {
                    case 1 -> {
                        try {
                            System.out.println("Enter the category");
                            String cat = input.nextLine();
                            ProductService productService = ApplicationContext.getProductService();
                            List<Product> products = productService.findByCategory(cat);
                            for (Product p : products) {
                                System.out.println(p);
                            }
                            addToCart();
                        } catch (InputMismatchException | SQLException e) {
                            System.out.println("wrong input");
                        }

                    }
                    case 2 -> {
                        try {
                            System.out.println("Enter the type");
                            String ty = input.nextLine();
                            ProductService productService = ApplicationContext.getProductService();
                            List<Product> products = productService.findByType(ty);
                            for (Product p : products) {
                                System.out.println(p);
                            }
                            addToCart();
                        } catch (InputMismatchException | SQLException e) {
                            System.out.println("wrong input");
                        }
                    }
                    case 3 -> {
                        ProductService productService = ApplicationContext.getProductService();
                        List<Product> products = productService.findAll();
                        for (Product p : products) {
                            System.out.println(p);
                        }
                        addToCart();
                    }
                    case 4 -> {
                        breakLoop = true;
                        Printer.printMsg(Constant.ALERT_EXIT);
                    }
                    default -> Printer.printMsg(Constant.ALERT_CHOICE);
                }

            }

        }
    }

    private static void addToCart(){
        int databaseItem;
        boolean breakLoop = false;

        while (!breakLoop) {

        }
    }
}
