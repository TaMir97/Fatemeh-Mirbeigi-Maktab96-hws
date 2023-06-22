package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Product;
import org.example.exception.NotDefinedCategory;
import org.example.exception.NotDefinedType;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends BaseService<Long, Product> {
    List<Product> findByCategory(String category) throws SQLException, NotDefinedCategory;
    List<Product> findByType(String type) throws SQLException, NotDefinedType;
    void updateAvailabilityAdd(Product product, int chosenItems) throws SQLException;
    void updateAvailabilityDelete(Product product, int chosenItems) throws SQLException;
}
