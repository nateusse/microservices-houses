package com.microserviceshouses.domain.usecases;


import com.microserviceshouses.domain.exceptions.CityDepartmentAlreadyExistsException;
import com.microserviceshouses.domain.model.CityDepartmentModel;
import com.microserviceshouses.domain.ports.in.CityDepartmentServicePort;
import com.microserviceshouses.domain.ports.out.CityDepartmentPersistencePort;

public class CityDepartmentUseCase implements CityDepartmentServicePort {

    private final CityDepartmentPersistencePort cityDepartmentPersistencePort;

    public CityDepartmentUseCase(CityDepartmentPersistencePort cityDepartmentPersistencePort) {
        this.cityDepartmentPersistencePort = cityDepartmentPersistencePort;
    }

    @Override
    public void save(CityDepartmentModel cityDepartmentModel) {

        String name = cityDepartmentModel.getName();
        CityDepartmentModel cityDepartment = cityDepartmentPersistencePort.getCityDepartmentByName(name);

        if (cityDepartment != null) {
            throw new CityDepartmentAlreadyExistsException();
        }

        cityDepartmentPersistencePort.save(cityDepartmentModel);

    }

}
