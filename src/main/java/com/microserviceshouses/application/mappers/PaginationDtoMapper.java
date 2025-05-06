package com.microserviceshouses.application.mappers;

import com.microserviceshouses.domain.model.pagination.PaginationRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaginationDtoMapper {
    PaginationRequestModel requestToModel(Integer page, Integer size, boolean orderAsc);
}
