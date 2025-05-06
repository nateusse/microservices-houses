package com.microserviceshouses.domain.ports.in;


import com.microserviceshouses.domain.model.CityDepartmentModel;

public interface CityDepartmentServicePort {

    void save(CityDepartmentModel cityDepartmentModel);
}
