package com.microserviceshouses.domain.model.pagination;


public class PaginationRequestModel {

    int page;
    int size;
    boolean orderAsc;

    public PaginationRequestModel(int page, int size, boolean orderAsc) {
        this.page = page;
        this.size = size;
        this.orderAsc = orderAsc;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public boolean isOrderAsc() {
        return orderAsc;
    }

}