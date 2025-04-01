package com.microserviceshouses.location.application.dto.response;

public record LocationResponse(
        Long locationId,
        String cityName,
        String cityDescription,
        String departmentName,
        String departmentDescription
) {}

