package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Product;
import org.example.exception.NotDefinedCategory;
import org.example.exception.NotDefinedType;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository extends BaseRepository<Long, Product> {
    List<Product> findByCategory(String category) throws SQLException, NotDefinedCategory;

    List<Product> findByType(String type) throws SQLException, NotDefinedType;

    void updateAvailability(Product product, int chosenItems) throws SQLException;

}
