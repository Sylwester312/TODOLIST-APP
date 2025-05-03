package com.example.demo.Mappers.impl;

import com.example.demo.Mappers.Mapper;
import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryMapper implements Mapper<Category, CategoryDto> {
    private ModelMapper modelMapper;

    @Override
    public CategoryDto mapTo(Category categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDto.class);
    }

    @Override
    public Category mapFrom(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
