package com.microserviceshouses.category.infrastructure.adapters.persistence;

import com.microserviceshouses.category.domain.model.CategoryModel;
import com.microserviceshouses.category.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.category.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.category.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
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
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }


    //TODO- implment constants
    @Override
    public List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination = orderAsc
                ? PageRequest.of(page, size, Sort.by("name").ascending())
                : PageRequest.of(page, size, Sort.by("name").descending());

        return categoryEntityMapper.entityListToModelList(
                categoryRepository.findAll(pagination).getContent()
        );
    }






}
