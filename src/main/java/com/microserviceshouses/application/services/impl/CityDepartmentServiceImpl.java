package com.microserviceshouses.application.services.impl;


import com.microserviceshouses.application.dto.request.SaveCityDepartmentRequest;
import com.microserviceshouses.application.dto.response.SaveCityDepartmentResponse;
import com.microserviceshouses.application.mappers.CityDepartmentDtoMapper;
import com.microserviceshouses.application.services.CityDepartmentService;
import com.microserviceshouses.commons.configurations.utils.Constants;
import com.microserviceshouses.domain.model.CityDepartmentModel;
import com.microserviceshouses.domain.ports.in.CityDepartmentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class CityDepartmentServiceImpl implements CityDepartmentService {

    private final CityDepartmentServicePort cityDepartmentServicePort;
    private final CityDepartmentDtoMapper cityDepartmentDtoMapper;

    @Override
    public SaveCityDepartmentResponse save(SaveCityDepartmentRequest saveCityDepartmentRequest) {
        CityDepartmentModel cityDepartmentModel = cityDepartmentDtoMapper.requestToModel(saveCityDepartmentRequest);
        cityDepartmentServicePort.save(cityDepartmentModel);
        LocalDateTime time = LocalDateTime.now();
        return new SaveCityDepartmentResponse(Constants.SAVE_CITY_DEPARTMENT_RESPONSE_MESSAGE, time);

    }

}