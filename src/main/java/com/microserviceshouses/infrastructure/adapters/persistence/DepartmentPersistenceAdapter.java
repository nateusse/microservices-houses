package com.microserviceshouses.infrastructure.adapters.persistence;

import com.microserviceshouses.domain.exceptions.DepartmentNameAlreadyExistsException;
import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.ports.out.DepartmentPersistencePort;
import com.microserviceshouses.infrastructure.mappers.DepartmentEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {

    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Override
    public void save(DepartmentModel model) {
        if (existsByName(model.getName())) {
            throw new DepartmentNameAlreadyExistsException();
        }
        departmentRepository.save(departmentEntityMapper.modelToEntity(model));
    }

    @Override
    public boolean existsByName(String name) {
        return departmentRepository.existsByName(name);
    }



}
