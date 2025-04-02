package com.microserviceshouses.infrastructure.adapters.persistence;

import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.ports.out.CityPersistencePort;
import com.microserviceshouses.infrastructure.mappers.CityEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CityPersistenceAdapter  implements CityPersistencePort {

    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public void save(CityModel cityModel) {
        cityRepository.save(cityEntityMapper.modelToEntity(cityModel));
    }
}
