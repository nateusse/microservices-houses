package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;

public interface LocationService {

    SaveLocationResponse save(SaveLocationRequest request);
}
