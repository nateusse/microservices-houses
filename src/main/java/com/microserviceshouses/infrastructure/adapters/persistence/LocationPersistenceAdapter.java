package com.microserviceshouses.infrastructure.adapters.persistence;


import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;
import com.microserviceshouses.infrastructure.entity.LocationEntity;
import com.microserviceshouses.infrastructure.exceptions.DatabaseInfraestructureException;
import com.microserviceshouses.infrastructure.mappers.LocationEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {

    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public void save(LocationModel locationModel) {
        LocationEntity locationEntity = locationEntityMapper.modelToEntity(locationModel);
        locationRepository.save(locationEntity);
    }

    @Override
    public PaginationResponseModel<LocationModel> findByCityNameOrDepartmentName(String name, String sortBy, boolean ascending, int page, int size) {
        try {
            String sortByColumn = (sortBy.equals("city")) ? "l.city" : "c.cityDepartment";
            Sort sort = Sort.by(ascending ? Sort.Direction.ASC : Sort.Direction.DESC, sortByColumn);
            Pageable pageable = PageRequest.of(page, size, sort);
            Page<Object[]> results = locationRepository.findByCityNameOrDepartmentNameWithPagination(name, pageable);

            List<LocationModel> locations = results.getContent().stream()
                    .map(result -> {
                        LocationEntity locationEntity = (LocationEntity) result[0];
                        String cityName = result[1] != null ? (String) result[1] : null;
                        String departmentName = result[2] != null ? (String) result[2] : null;

                        LocationModel locationModel = locationEntityMapper.entityToModel(locationEntity);
                        locationModel.setCityName(cityName);
                        locationModel.setDepartmentName(departmentName);
                        return locationModel;
                    })
                    .collect(Collectors.toList());

            return new PaginationResponseModel<>(locations, results.getTotalPages(), (int) results.getTotalElements());
        } catch (Exception e) {
            throw  new DatabaseInfraestructureException();
        }
    }

}
