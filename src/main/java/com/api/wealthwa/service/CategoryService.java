package com.api.wealthwa.service;

import com.api.wealthwa.model.Categorys;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    List<Categorys> getAllCategory();

    Optional<Categorys> getCategoryById(UUID categoryId);

}
