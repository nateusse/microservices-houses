package com.microserviceshouses.infrastructure.adapters.persistence;


import com.microserviceshouses.domain.model.CityDepartmentModel;
import com.microserviceshouses.domain.ports.out.CityDepartmentPersistencePort;
import com.microserviceshouses.infrastructure.entity.CityDepartmentEntity;
import com.microserviceshouses.infrastructure.mappers.CityDepartmentEntityMapper;
import com.microserviceshouses.infrastructure.repositories.mysql.CityDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class CityDepartmentPersistenceAdapter implements CityDepartmentPersistencePort {

    private final CityDepartmentRepository cityDepartmentRepository;
    private final CityDepartmentEntityMapper cityDepartmentEntityMapper;

    @Override
    public void save(CityDepartmentModel cityDepartmentModel) {
        CityDepartmentEntity entity = cityDepartmentEntityMapper.modelToEntity(cityDepartmentModel);
        cityDepartmentRepository.save(entity);
    }

    @Override
    public CityDepartmentModel getCityDepartmentByName(String cityDepartmentName) {
        CityDepartmentEntity entity = cityDepartmentRepository.findByName(cityDepartmentName).orElse(null);
        return cityDepartmentEntityMapper.entityToModel(entity);
    }

    @Override
    public CityDepartmentModel getCityDepartmentById(Long id) {
        CityDepartmentEntity entity = cityDepartmentRepository.findById(id).orElse(null);
        return cityDepartmentEntityMapper.entityToModel(entity);
    }


}
