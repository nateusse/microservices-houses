package com.microserviceshouses.domain.model;


import java.util.List;

public class PageModel<T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int currentPage;
    private boolean hasNextPage;
    private long totalPages;
    private boolean isLastPage;
    private boolean hasPreviousPage;

    public PageModel(List<T> content, int pageNumber,
                     int pageSize, int totalElements,
                     int currentPage, boolean hasNextPage,
                     long totalPages, boolean isLastPage,
                     boolean hasPreviousPage) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.hasNextPage = hasNextPage;
        this.totalPages = totalPages;
        this.isLastPage = isLastPage;
        this.hasPreviousPage = hasPreviousPage;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }
}
