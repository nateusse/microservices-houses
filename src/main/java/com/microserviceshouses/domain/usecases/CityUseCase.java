package com.microserviceshouses.domain.usecases;


import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.ports.in.CityServicePort;
import com.microserviceshouses.domain.ports.out.CityPersistencePort;

import java.util.List;


public class CityUseCase implements CityServicePort {

    private final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public void save(CityModel cityModel) {
        cityPersistencePort.save(cityModel);
    }

    @Override
    public List<CityModel> getCities() {
        return List.of();
    }


}
