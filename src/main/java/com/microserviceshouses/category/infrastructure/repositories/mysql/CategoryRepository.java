package com.microserviceshouses.category.infrastructure.repositories.mysql;

import com.microserviceshouses.category.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
