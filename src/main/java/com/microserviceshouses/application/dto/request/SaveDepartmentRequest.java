package com.microserviceshouses.application.dto.request;

public record SaveDepartmentRequest(
        String name,
        String description
) {}