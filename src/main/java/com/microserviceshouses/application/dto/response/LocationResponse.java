package com.microserviceshouses.application.dto.response;


public record LocationResponse(
        Long id,
        String neighborhood,
        String cityName,
        String departmentName
){ }

