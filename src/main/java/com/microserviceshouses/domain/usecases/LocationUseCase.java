package com.microserviceshouses.domain.usecases;


import com.microserviceshouses.domain.exceptions.CityNotExistException;
import com.microserviceshouses.domain.exceptions.LocationSortByException;
import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import com.microserviceshouses.domain.ports.out.CityPersistencePort;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;
import com.microserviceshouses.domain.utils.constants.SortByEnum;

public class LocationUseCase implements LocationServicePort {

    private final LocationPersistencePort locationPersistencePort;
    private final CityPersistencePort cityPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort, CityPersistencePort cityPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public void save(LocationModel locationModel) {
        long cityId = locationModel.getCityId();
        if (cityPersistencePort.getCityById(cityId) == null) {
            throw new CityNotExistException();
        }
        locationPersistencePort.save(locationModel);
    }
    @Override
    public PaginationResponseModel<LocationModel> getLocationsByCityOrDepartmentName(String name, String sortBy, boolean ascending, int page, int size) {
        validateSortBy(sortBy);
        PaginationResponseModel<LocationModel> locations = locationPersistencePort.findByCityNameOrDepartmentName(name, sortBy, ascending, page, size);
        return locations;
    }

    private void validateSortBy(String sortBy) {
        if (!SortByEnum.isValid(sortBy)) {
            throw new LocationSortByException();
        }
    }


}
