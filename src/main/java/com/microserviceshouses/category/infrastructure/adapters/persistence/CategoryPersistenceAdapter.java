package com.microserviceshouses.category.infrastructure.adapters.persistence;

import com.microserviceshouses.category.domain.model.CategoryModel;
import com.microserviceshouses.category.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.category.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.category.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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




}
