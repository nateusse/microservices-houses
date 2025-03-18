package com.microserviceshouses.locations.domain.usecases;

import com.microserviceshouses.category.domain.exceptions.CategoryAlreadyExistsException;
import com.microserviceshouses.locations.domain.model.LocationModel;
import com.microserviceshouses.locations.domain.ports.in.LocationServicePort;
import com.microserviceshouses.locations.domain.ports.out.LocationPersistencePort;

public class LocationUseCase  implements LocationServicePort {

    private final LocationPersistencePort locationPersistencePort;


    public LocationUseCase(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }


    @Override
    public void save(LocationModel locationModel) {
        locationPersistencePort.save(locationModel);
    }
}
