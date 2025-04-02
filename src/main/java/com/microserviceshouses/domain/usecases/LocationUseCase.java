package com.microserviceshouses.domain.usecases;


import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;

public class LocationUseCase  implements LocationServicePort {

    private final LocationPersistencePort locationPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public void save(LocationModel location) {
        if (locationPersistencePort.existsBySectorAndCity(
                location.getSectorOrNeighborhood(),
                location.getCity().getName()
        )) {
            throw new RuntimeException("Location already exists in this city");
        }

        locationPersistencePort.save(location);
    }
}
