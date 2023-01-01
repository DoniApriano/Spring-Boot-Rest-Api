package com.latihan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.latihan.models.entities.Category;
import com.latihan.models.repo.CategoryRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category findOne(Long id) {
        Optional<Category> category = categoryRepo.findById(id);

        if (!category.isPresent()) {
            return null;
        }
        return category.get();
    }

    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    public void removeOne(Long id) {
        categoryRepo.deleteById(id);
    }

    public Iterable<Category> findByName(String name, Pageable pageable) {
        return categoryRepo.findByNameContains(name, pageable);
    }

    public Iterable<Category> saveBatch(Iterable<Category> categories) {
        return categoryRepo.saveAll(categories);
    }

}
