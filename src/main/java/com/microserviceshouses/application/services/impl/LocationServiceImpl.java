package com.microserviceshouses.application.services.impl;


import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.application.dto.response.PaginationResponse;
import com.microserviceshouses.commons.configurations.utils.Constants;
import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;
import com.microserviceshouses.application.mappers.LocationDtoMapper;
import com.microserviceshouses.application.services.LocationService;
import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationServicePort locationServicePort;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public SaveLocationResponse save(SaveLocationRequest saveLocationRequest) {
        LocationModel model = locationDtoMapper.requestToModel(saveLocationRequest);
        locationServicePort.save(model);
        return new SaveLocationResponse(Constants.SAVE_LOCATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PaginationResponse<LocationResponse> getLocationsFiltered(String name, String sortBy, boolean orderAsc, int page, int size) {
        PaginationResponseModel<LocationModel> locations = locationServicePort.getLocationsByCityOrDepartmentName(name, sortBy , orderAsc, page, size);
        PaginationResponse<LocationResponse> locationsResponse = locationDtoMapper.modelListToResponseList(locations);
        return locationsResponse;
    }


}