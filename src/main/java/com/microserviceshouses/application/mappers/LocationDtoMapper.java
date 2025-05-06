package com.microserviceshouses.application.mappers;

import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.application.dto.response.PaginationResponse;
import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDtoMapper {
    LocationModel requestToModel(SaveLocationRequest saveLocationRequest);
    LocationResponse modelToResponse(LocationModel locationModel);

    default PaginationResponse<LocationResponse> modelListToResponseList(PaginationResponseModel<LocationModel> paginationResponseModel) {
        List<LocationResponse> locationResponses = paginationResponseModel.getContent().stream()
                .map(this::modelToResponse)
                .collect(Collectors.toList());

        return new PaginationResponse<>(
                locationResponses,
                paginationResponseModel.getTotalPages(),
                paginationResponseModel.getTotalElements()
        );
    }
}