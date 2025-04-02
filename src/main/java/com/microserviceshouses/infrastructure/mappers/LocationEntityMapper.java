package com.microserviceshouses.infrastructure.mappers;

import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.infrastructure.entity.LocationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CityEntityMapper.class)
public interface LocationEntityMapper {
    LocationEntity modelToEntity(LocationModel locationModel);
    LocationModel entityToModel(LocationEntity locationEntity);
    List<LocationModel> entityListToModelList(List<LocationEntity> entities);
}

