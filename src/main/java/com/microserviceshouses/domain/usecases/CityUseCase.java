package com.microserviceshouses.domain.usecases;


import com.microserviceshouses.domain.exceptions.CityDepartmentNotExist;
import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.ports.in.CityServicePort;
import com.microserviceshouses.domain.ports.out.CityDepartmentPersistencePort;
import com.microserviceshouses.domain.ports.out.CityPersistencePort;

public class CityUseCase implements CityServicePort
{

    private final CityDepartmentPersistencePort cityDepartmentPersistencePort;
    private final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityDepartmentPersistencePort cityDepartmentPersistencePort, CityPersistencePort cityPersistencePort) {
        this.cityDepartmentPersistencePort = cityDepartmentPersistencePort;
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public void save(CityModel cityModel) {
        long departmentId = cityModel.getCityDepartmentId();

        if (cityDepartmentPersistencePort.getCityDepartmentById(departmentId) == null) {
            throw new CityDepartmentNotExist();
        }
        cityPersistencePort.save(cityModel);
    }


}
