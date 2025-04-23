package com.microserviceshouses.infrastructure.adapters.persistence;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CategoryRepository;
import com.microserviceshouses.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public CategoryModel getCategoryByName(String name) {
        return categoryEntityMapper.entityToModel(
                categoryRepository.findByName(name).orElse(null)
        );
    }

    @Override
    public Page<CategoryModel> getCategoriesByName(String name, Pageable pageable) {
        return categoryRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(categoryEntityMapper::entityToModel);
    }


}
