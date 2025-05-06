package com.microserviceshouses.infrastructure.adapters.persistence;


import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.ports.out.CityPersistencePort;
import com.microserviceshouses.infrastructure.entity.CityEntity;
import com.microserviceshouses.infrastructure.mappers.CityEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CityPersitenceAdapter implements CityPersistencePort {

    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public void save(CityModel cityModel) {
        CityEntity entity = cityEntityMapper.modelToEntity(cityModel);
        cityRepository.save(entity);
    }


    private List<CityModel> mapList(List<CityEntity> entityList) {
        return entityList.stream()
                .map(cityEntityMapper::entityToModel)
                .toList();
    }

}
