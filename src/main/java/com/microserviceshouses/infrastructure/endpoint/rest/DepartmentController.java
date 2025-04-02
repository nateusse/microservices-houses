package com.microserviceshouses.infrastructure.endpoint.rest;

import com.microserviceshouses.application.dto.request.SaveDepartmentRequest;
import com.microserviceshouses.application.dto.response.DepartmentResponse;
import com.microserviceshouses.application.dto.response.SaveDepartmentResponse;
import com.microserviceshouses.application.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<SaveDepartmentResponse> createDepartment(@RequestBody SaveDepartmentRequest request) {
        SaveDepartmentResponse response = departmentService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}