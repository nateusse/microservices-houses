package com.microserviceshouses.infrastructure.mappers;


import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.infrastructure.entity.CityEntity;
import com.microserviceshouses.infrastructure.entity.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LocationEntityMapper {

    @Mapping(source = "cityId", target = "city", qualifiedByName = "mapCityDepartmentIdToEntity")
    LocationEntity modelToEntity(LocationModel locationModel);
    @Mapping(source = "city.id", target = "cityId")
    LocationModel entityToModel(LocationEntity locationEntity);

    @Named("mapCityDepartmentIdToEntity")
    default CityEntity mapCityIdToEntity(Long cityId) {
        if (cityId == null) {
            return null;
        }
        CityEntity city = new CityEntity();
        city.setId(cityId);
        return city;
    }

}
