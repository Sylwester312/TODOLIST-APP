package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    boolean existsByNameAndUser(String name, User user);

    Optional<Category> findByName(String name);

    List<Category> findByUser(User user);
}
