package com.microserviceshouses.infrastructure.adapters.persistence;

import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.ports.out.DepartmentPersistencePort;
import com.microserviceshouses.infrastructure.mappers.DepartmentEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {

    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper mapper;

    @Override
    public void save(DepartmentModel model) {
        if (departmentRepository.existsByName(model.getName())) {
            throw new RuntimeException("Department already exists");
        }
        departmentRepository.save(mapper.modelToEntity(model));
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}

