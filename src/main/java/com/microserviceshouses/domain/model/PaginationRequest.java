package com.microserviceshouses.domain.model;

public class PaginationRequest {

    private int page;
    private int size;
    private boolean sortAsc;

    public PaginationRequest(int page, int size, boolean sortAsc) {
        this.page = page;
        this.size = size;
        this.sortAsc = sortAsc;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSortAsc(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }
}
