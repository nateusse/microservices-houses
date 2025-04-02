package com.microserviceshouses.application.services.impl;

import com.microserviceshouses.application.dto.request.SaveDepartmentRequest;
import com.microserviceshouses.application.dto.response.DepartmentResponse;
import com.microserviceshouses.application.dto.response.SaveDepartmentResponse;
import com.microserviceshouses.application.mappers.DepartmentDtoMapper;
import com.microserviceshouses.application.services.DepartmentService;
import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.ports.in.DepartmentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentServicePort departmentServicePort;
    private final DepartmentDtoMapper mapper;

    @Override
    public SaveDepartmentResponse save(SaveDepartmentRequest request) {
        DepartmentModel model = mapper.requestToModel(request);
        departmentServicePort.save(model);

        return new SaveDepartmentResponse(
                model.getId(),
                model.getName(),
                model.getDescription(),
                "Department saved successfully"
        );
    }

    @Override
    public List<DepartmentResponse> getAll() {
        return List.of();
    }
}