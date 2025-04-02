package com.microserviceshouses.application.dto.response;

import java.util.UUID;

public record SaveDepartmentResponse(
        UUID id,
        String name,
        String description,
        String message
) {}
