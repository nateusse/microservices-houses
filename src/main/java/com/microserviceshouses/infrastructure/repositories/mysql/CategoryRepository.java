package com.microserviceshouses.infrastructure.repositories.mysql;

import com.microserviceshouses.infrastructure.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByName(String name);
    Page<CategoryEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<CategoryEntity> findAll(Pageable pageable);
    Optional<CategoryEntity> findByName(String name);
}
