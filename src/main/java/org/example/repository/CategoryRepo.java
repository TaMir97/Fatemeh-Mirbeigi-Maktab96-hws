package org.example.repository;

import org.example.entity.Category;

public interface CategoryRepo {
    void addNewCategory(Category category);

    int updateCategory(Category category);

    int deleteCategory(Category category);

    Category isExist(String categoryName);

    Category[] loadAllCategories();
}
