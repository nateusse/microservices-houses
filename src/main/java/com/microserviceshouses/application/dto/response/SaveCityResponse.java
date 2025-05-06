package com.microserviceshouses.application.dto.response;

import java.time.LocalDateTime;

public record SaveCityResponse(
        String message,
        LocalDateTime time
) { }
