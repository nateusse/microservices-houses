package com.microserviceshouses.application.dto.response;



public record SaveDepartmentResponse(
        Long id,
        String name,
        String description,
        String message
) {}
