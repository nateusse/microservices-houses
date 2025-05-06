package com.microserviceshouses.application.dto.response;

import java.time.LocalDateTime;

public record SaveCityDepartmentResponse (
        String message,
        LocalDateTime time) {
}