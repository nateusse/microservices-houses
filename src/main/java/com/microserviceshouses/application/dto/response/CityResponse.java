package com.microserviceshouses.application.dto.response;

public record CityResponse(
        Long id,
        String name,
        String description,
        String departmentName
) {}
