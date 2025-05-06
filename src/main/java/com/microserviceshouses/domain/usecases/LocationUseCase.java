package com.microserviceshouses.domain.usecases;

import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import com.microserviceshouses.domain.ports.out.CityPersistencePort;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;

public class LocationUseCase implements LocationServicePort {

    private final LocationPersistencePort locationPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort, CityPersistencePort cityPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public void save(LocationModel locationModel) {
        long cityId = locationModel.getCityId();
        locationPersistencePort.save(locationModel);
    }



}
