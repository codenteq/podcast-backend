package com.podcast.demo.services.category;

import com.podcast.demo.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> list();
    Category find(UUID id);
    Category create(Category category);
    Category update(UUID id, Category category);
    void delete(UUID id);
}
