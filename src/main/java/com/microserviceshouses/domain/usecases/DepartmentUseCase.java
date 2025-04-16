package com.microserviceshouses.domain.usecases;

import com.microserviceshouses.domain.exceptions.DepartmentNameAlreadyExistsException;
import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.ports.in.DepartmentServicePort;
import com.microserviceshouses.domain.ports.out.DepartmentPersistencePort;

public class DepartmentUseCase implements DepartmentServicePort {

    private final DepartmentPersistencePort departmentPersistencePort;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort) {
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public void validateUniqueName(String name) {
        if (departmentPersistencePort.existsByName(name)) {
            throw new DepartmentNameAlreadyExistsException();
        }
    }

    @Override
    public void save(DepartmentModel departmentModel) {
        if (departmentPersistencePort.existsByName(departmentModel.getName())) {
            throw new DepartmentNameAlreadyExistsException();
        }
        departmentPersistencePort.save(departmentModel);
    }
}
