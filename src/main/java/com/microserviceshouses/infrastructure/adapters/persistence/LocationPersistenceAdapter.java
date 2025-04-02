package com.microserviceshouses.infrastructure.adapters.persistence;



import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.ports.out.LocationPersistencePort;
import com.microserviceshouses.infrastructure.mappers.LocationEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {

    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public void save(LocationModel locationModel) {
        locationRepository.save(locationEntityMapper.modelToEntity(locationModel));
    }

    @Override
    public boolean existsBySectorAndCity(String sector, String cityName) {
        return false;
    }


}