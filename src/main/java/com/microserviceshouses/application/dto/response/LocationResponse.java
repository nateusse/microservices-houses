package com.microserviceshouses.application.dto.response;


import java.time.LocalDateTime;

public record LocationResponse(
        Long id,
        String neighborhood,
        String cityName,
        String departmentName
){ }

