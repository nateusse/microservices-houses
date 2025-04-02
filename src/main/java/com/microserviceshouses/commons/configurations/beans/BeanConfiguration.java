package com.microserviceshouses.commons.configurations.beans;

import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.domain.usecases.CategoryUseCase;
import com.microserviceshouses.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.microserviceshouses.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CategoryRepository;
import com.microserviceshouses.domain.ports.in.DepartmentServicePort;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import com.microserviceshouses.domain.ports.out.DepartmentPersistencePort;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;
import com.microserviceshouses.domain.usecases.DepartmentUseCase;
import com.microserviceshouses.domain.usecases.LocationUseCase;
import com.microserviceshouses.infrastructure.adapters.persistence.DepartmentPersistenceAdapter;
import com.microserviceshouses.infrastructure.adapters.persistence.LocationPersistenceAdapter;
import com.microserviceshouses.infrastructure.mappers.DepartmentEntityMapper;
import com.microserviceshouses.infrastructure.mappers.LocationEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.DepartmentRepository;
import com.microserviceshouses.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public LocationServicePort locationServicePort() {
        return new LocationUseCase(locationPersistencePort());
    }

    @Bean
    public LocationPersistencePort locationPersistencePort() {
        return new LocationPersistenceAdapter(locationRepository, locationEntityMapper);
    }

    @Bean
    public DepartmentServicePort departmentServicePort() {
        return new DepartmentUseCase(departmentPersistencePort());
    }

    @Bean
    public DepartmentPersistencePort departmentPersistencePort() {
        return new DepartmentPersistenceAdapter(departmentRepository, departmentEntityMapper);
    }

}
