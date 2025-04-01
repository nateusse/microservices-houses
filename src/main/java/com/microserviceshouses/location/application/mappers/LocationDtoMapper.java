package com.microserviceshouses.location.application.mappers;

import com.microserviceshouses.location.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.location.application.dto.response.LocationResponse;
import com.microserviceshouses.location.domain.model.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDtoMapper {


    LocationModel requestToModel(SaveLocationRequest request);
    LocationResponse modelToResponse(LocationModel locationModel);

}
