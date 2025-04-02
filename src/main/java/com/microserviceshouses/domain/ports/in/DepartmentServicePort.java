package com.microserviceshouses.domain.ports.in;

import com.microserviceshouses.domain.model.DepartmentModel;

public interface DepartmentServicePort {
    void save(DepartmentModel departmentModel);
    void validateUniqueName(String name);

}
