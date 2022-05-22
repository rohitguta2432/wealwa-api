package com.api.wealthwa.service;

import com.api.wealthwa.model.Categorys;
import com.api.wealthwa.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class CategoryServiceImpl implements  CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Categorys> getAllCategory() {
        log.info("get all category : {}");
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Categorys> getCategoryById(UUID categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
