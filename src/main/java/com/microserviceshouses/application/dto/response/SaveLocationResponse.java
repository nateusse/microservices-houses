package com.microserviceshouses.application.dto.response;


import java.time.LocalDateTime;

public record SaveLocationResponse(
        String message,
        LocalDateTime time
) {}