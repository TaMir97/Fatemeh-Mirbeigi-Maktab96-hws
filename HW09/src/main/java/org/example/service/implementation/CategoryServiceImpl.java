package org.example.service.implementation;

import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory() {
        categoryRepository.addCategory();
    }
}
