package com.microserviceshouses.commons.configurations.beans;

import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.domain.ports.in.CityDepartmentServicePort;
import com.microserviceshouses.domain.ports.in.CityServicePort;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.domain.ports.out.CityDepartmentPersistencePort;
import com.microserviceshouses.domain.ports.out.CityPersistencePort;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;
import com.microserviceshouses.domain.usecases.CategoryUseCase;
import com.microserviceshouses.domain.usecases.CityDepartmentUseCase;
import com.microserviceshouses.domain.usecases.CityUseCase;
import com.microserviceshouses.domain.usecases.LocationUseCase;
import com.microserviceshouses.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.microserviceshouses.infrastructure.adapters.persistence.CityDepartmentPersistenceAdapter;
import com.microserviceshouses.infrastructure.adapters.persistence.CityPersitenceAdapter;
import com.microserviceshouses.infrastructure.adapters.persistence.LocationPersistenceAdapter;
import com.microserviceshouses.infrastructure.mappers.CategoryEntityMapper;
import com.microserviceshouses.infrastructure.mappers.CityDepartmentEntityMapper;
import com.microserviceshouses.infrastructure.mappers.CityEntityMapper;
import com.microserviceshouses.infrastructure.mappers.LocationEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CategoryRepository;
import com.microserviceshouses.infrastructure.repositories.mysql.CityDepartmentRepository;
import com.microserviceshouses.infrastructure.repositories.mysql.CityRepository;
import com.microserviceshouses.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    private final CityDepartmentRepository cityDepartmentRepository;
    private final CityDepartmentEntityMapper cityDepartmentEntityMapper;

    private final CityRepository cityRepository;

    private final CityEntityMapper cityEntityMapper;

    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public CityServicePort cityServicePort() {
        return new CityUseCase(cityDepartmentPersistencePort() ,cityPersistencePort());
    }

    @Bean
    public LocationServicePort locationServicePort() {
        return new LocationUseCase(locationPersistencePort() ,cityPersistencePort());
    }

    @Bean
    public CityDepartmentServicePort cityDepartmentServicePort() {
        return new CityDepartmentUseCase(cityDepartmentPersistencePort());
    }

    @Bean
    public CityDepartmentPersistencePort cityDepartmentPersistencePort() {
        return new CityDepartmentPersistenceAdapter(cityDepartmentRepository, cityDepartmentEntityMapper);
    };

    @Bean
    public CityPersistencePort cityPersistencePort() {
        return new CityPersitenceAdapter(cityRepository, cityEntityMapper);
    };

    public LocationPersistencePort locationPersistencePort() {
        return new LocationPersistenceAdapter(locationRepository, locationEntityMapper);
    };

}