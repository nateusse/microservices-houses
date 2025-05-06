package com.microserviceshouses.domain.ports.out;


import com.microserviceshouses.domain.model.CityDepartmentModel;

import java.util.List;

public interface CityDepartmentPersistencePort {

    void save(CityDepartmentModel cityDepartmentModel);

    CityDepartmentModel getCityDepartmentByName(String cityDepartmentName);
    CityDepartmentModel getCityDepartmentById(Long id);



}
