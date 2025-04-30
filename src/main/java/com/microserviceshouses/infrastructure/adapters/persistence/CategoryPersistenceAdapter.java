package com.microserviceshouses.infrastructure.adapters.persistence;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CategoryRepository;
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


    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }


}
