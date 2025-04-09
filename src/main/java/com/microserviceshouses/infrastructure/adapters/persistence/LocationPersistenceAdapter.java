package com.microserviceshouses.infrastructure.adapters.persistence;


import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;
import com.microserviceshouses.infrastructure.entity.CityEntity;
import com.microserviceshouses.infrastructure.entity.LocationEntity;
import com.microserviceshouses.infrastructure.mappers.LocationEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CityRepository;
import com.microserviceshouses.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {

    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;
    private final CityRepository cityRepository;

    @Override
    public void save(LocationModel locationModel) {
        Long cityId = locationModel.getCity().getId();
        CityEntity city = cityRepository.findById(locationModel.getCity().getId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        LocationEntity entity = locationEntityMapper.modelToEntity(locationModel);
        entity.setCity(city);
    }

    @Override
    public boolean existsBySectorAndCity(String sector, String cityName) {
        return false;
    }

    public List<LocationModel> getLocations(Integer page, Integer size, boolean orderAsc) {
        Pageable pageable = PageRequest.of(page, size,
                orderAsc ? Sort.by("city.name").ascending() : Sort.by("city.name").descending());
        return locationRepository.findAll(pageable)
                .stream()
                .map(locationEntityMapper::entityToModel)
                .toList();
    }

    @Override
    public List<LocationModel> searchLocations(String text, String orderBy, boolean ascending, int page, int size) {
        Sort.Direction direction = ascending ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = switch (orderBy.toLowerCase()) {
            case "city" -> Sort.by(direction, "city.name");
            case "department" -> Sort.by(direction, "city.department.name");
            default -> Sort.by(direction, "city.name");
        };

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<LocationEntity> result = locationRepository.searchByCityOrDepartment(text, pageable);
        return result.stream()
                .map(locationEntityMapper::entityToModel)
                .toList();
    }

 //errror repo//debugg
    //debuggin with brak points


}