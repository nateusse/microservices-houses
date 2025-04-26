package com.microserviceshouses.domain.utils;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GenericPersistancePort<T>{

    void save(T model);
    boolean existsByName(String name);
    Page<T> getCategoriesByName(String name, Pageable pageable);
}
