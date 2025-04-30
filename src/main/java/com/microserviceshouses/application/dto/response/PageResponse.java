package com.microserviceshouses.application.dto.response;

import java.util.List;

public record PageResponse(List<T> content, int page, int size, boolean orderAs){}

