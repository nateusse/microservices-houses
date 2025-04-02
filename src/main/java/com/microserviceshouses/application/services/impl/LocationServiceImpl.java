package com.microserviceshouses.application.services.impl;


import com.microserviceshouses.commons.configurations.utils.Constants;
import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;
import com.microserviceshouses.application.mappers.LocationDtoMapper;
import com.microserviceshouses.application.services.LocationService;
import com.microserviceshouses.domain.ports.in.LocationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationServicePort locationServicePort;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public SaveLocationResponse save(SaveLocationRequest request) {
        locationServicePort.save(locationDtoMapper.requestToModel(request));
        return new SaveLocationResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE);
    }
}

