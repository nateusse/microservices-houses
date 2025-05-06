package com.microserviceshouses.domain.model.pagination;

import java.util.List;


public class PaginationResponseModel<T> {

    List<T> content;
    int totalPages;
    int totalElements;

    public PaginationResponseModel(List<T> content, int totalPages, int totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public int getTotalElements() {
        return totalElements;
    }

}