package com.microserviceshouses.application.dto.request;

public record SaveCityRequest (
        String name,
        String description,
        Long   cityDepartmentId
) { }