package com.microserviceshouses.domain.usecases;

import com.microserviceshouses.domain.exceptions.LocationAlreadyExist;
import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;
import java.util.List;

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
            throw new LocationAlreadyExist();
        }

        locationPersistencePort.save(location);
    }

    @Override
    public List<CategoryModel> getLocations(Integer page, Integer size, boolean orderAsc) {
        return List.of();
    }

    @Override
    public List<LocationModel> searchLocations(String text, String orderBy, boolean ascending, int page, int size) {
        return locationPersistencePort.searchLocations(text, orderBy, ascending, page, size);
    }
}
