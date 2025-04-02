package com.microserviceshouses.application.services.impl;

import com.microserviceshouses.application.dto.request.SaveCityRequest;
import com.microserviceshouses.application.dto.response.SaveCityResponse;
import com.microserviceshouses.application.mappers.CityDtoMapper;
import com.microserviceshouses.application.services.CityService;
import com.microserviceshouses.commons.configurations.utils.Constants;
import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.ports.in.CityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDtoMapper cityDtoMapper;
    private final CityServicePort cityServicePort;

    @Override
    public SaveCityResponse save(SaveCityRequest request) {
        CityModel model = cityDtoMapper.requestToModel(request);
        cityServicePort.save(model);
        return new SaveCityResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }




}
