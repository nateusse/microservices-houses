package com.microserviceshouses.domain.ports.out;

import com.microserviceshouses.domain.model.DepartmentModel;

public interface DepartmentPersistencePort {

    void save(DepartmentModel departmentModel);
    boolean existsByName(String name);

}
