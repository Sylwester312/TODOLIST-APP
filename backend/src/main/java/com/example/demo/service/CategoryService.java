package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.request.CategoryRequest;

import java.security.Principal;
import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategoriesOfUser(String email);

    CategoryDto getCategoryById(Long id, Principal principal);

    CategoryDto addCategory(CategoryRequest categoryRequest, String userEmail);

    CategoryDto updateCategory(Long id, CategoryRequest categoryRequest, Principal principal);

    void deleteCategory(Long id, Principal principal);
}
