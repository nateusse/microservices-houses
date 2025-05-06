package com.microserviceshouses.infrastructure.adapters.persistence;
import com.microserviceshouses.commons.configurations.utils.Constants;
import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.pagination.PaginationRequestModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.infrastructure.entity.CategoryEntity;
import com.microserviceshouses.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        CategoryEntity entity = categoryEntityMapper.modelToEntity(categoryModel);
        categoryRepository.save(entity);
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {

        CategoryEntity entity = categoryRepository.findByName(categoryName).orElse(null);
        return categoryEntityMapper.entityToModel(entity);

    }

    @Override
    public PaginationResponseModel<CategoryModel> getCategories(PaginationRequestModel paginationRequestModel) {
        Pageable pagination;
        if (paginationRequestModel.isOrderAsc()) pagination = PageRequest.of(paginationRequestModel.getPage(), paginationRequestModel.getSize(), Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(paginationRequestModel.getPage(), paginationRequestModel.getSize(), Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        Page<CategoryEntity> page = categoryRepository.findAll(pagination);
        PaginationResponseModel<CategoryModel> paginationResponse = new PaginationResponseModel<>(
                categoryEntityMapper.entityListToModelList(categoryRepository.findAll(pagination).getContent()),
                page.getTotalPages(),
                (int) page.getTotalElements());
        return paginationResponse;
    }
}
