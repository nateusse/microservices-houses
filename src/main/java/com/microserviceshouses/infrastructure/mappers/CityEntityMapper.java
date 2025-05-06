package com.microserviceshouses.infrastructure.mappers;

import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.infrastructure.entity.CityDepartmentEntity;
import com.microserviceshouses.infrastructure.entity.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CityEntityMapper {

    @Mapping(source = "cityDepartmentId", target = "cityDepartment", qualifiedByName = "mapCityDepartmentIdToEntity")
    CityEntity modelToEntity(CityModel cityModel);

    @Mapping(source = "cityDepartment.id", target = "cityDepartmentId")
    CityModel entityToModel(CityEntity cityEntity);

    @Named("mapCityDepartmentIdToEntity")
    default CityDepartmentEntity mapCityDepartmentIdToEntity(Long cityDepartmentId) {
        if (cityDepartmentId == null) {
            return null;
        }
        CityDepartmentEntity cityDepartment = new CityDepartmentEntity();
        cityDepartment.setId(cityDepartmentId);
        return cityDepartment;
    }

}
