package com.microserviceshouses.application.dto.response;

import java.util.List;

public class PageDto<T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private boolean hasNextPage;
    private long totalPages;
    private boolean isLastPage;

    public PageDto(List<T> content, int pageNumber, int pageSize,
                   int totalElements, boolean hasNextPage,
                   long totalPages, boolean isLastPage) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.hasNextPage = hasNextPage;
        this.totalPages = totalPages;
        this.isLastPage = isLastPage;
    }

}
