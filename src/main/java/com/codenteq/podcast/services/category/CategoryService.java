package com.codenteq.podcast.services.category;

import com.codenteq.podcast.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> list();
    Category find(UUID id);
    Category create(Category category);
    Category update(UUID id, Category category);
    void delete(UUID id);
}
