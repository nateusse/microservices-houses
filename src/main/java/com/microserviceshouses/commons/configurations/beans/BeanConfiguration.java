package com.microserviceshouses.commons.configurations.beans;

import com.microserviceshouses.category.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.category.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.category.domain.usecases.CategoryUseCase;
import com.microserviceshouses.category.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.microserviceshouses.category.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.category.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }
}
