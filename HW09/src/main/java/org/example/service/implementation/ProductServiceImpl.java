package org.example.service.implementation;

import org.example.base.service.implementation.BaseServiceImpl;
import org.example.entity.Categories;
import org.example.entity.Product;
import org.example.entity.Types;
import org.example.exception.NotDefinedCategory;
import org.example.exception.NotDefinedType;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl extends BaseServiceImpl<Long, Product, ProductRepository>
        implements ProductService {
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    @Override
    public List<Product> findByCategory(String category) throws SQLException, NotDefinedCategory {
        Categories check = Categories.valueOf(category);
        if (check == null) {
            return repository.findByCategory(category);
        } else
            throw new NotDefinedCategory("the category is not defined");
    }

    @Override
    public List<Product> findByType(String type) throws SQLException, NotDefinedType {
        Types check = Types.valueOf(type);
        if (check == null) {
            return repository.findByCategory(type);
        } else
            throw new NotDefinedCategory("the type is not defined");
    }

    @Override
    public void updateAvailabilityAdd(Product product, int chosenItems) throws SQLException {
        repository.updateAvailabilityAdd(product, chosenItems);
    }

    @Override
    public void updateAvailabilityDelete(Product product, int chosenItems) throws SQLException {
        repository.updateAvailabilityDelete(product, chosenItems);
    }
}
