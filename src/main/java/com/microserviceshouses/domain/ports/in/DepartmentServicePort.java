package com.microserviceshouses.domain.ports.in;

import com.microserviceshouses.domain.model.DepartmentModel;

public interface DepartmentServicePort {
    void validateUniqueName(String name);
    void save(DepartmentModel departmentModel);
}
