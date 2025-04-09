package com.microserviceshouses.infrastructure.repositories.mysql;

import com.microserviceshouses.infrastructure.entity.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    @Query("""
    SELECT l FROM LocationEntity l
    JOIN FETCH l.city c
    JOIN FETCH c.department d
    WHERE LOWER(TRIM(c.name)) LIKE LOWER(CONCAT('%', :text, '%'))
       OR LOWER(TRIM(d.name)) LIKE LOWER(CONCAT('%', :text, '%'))
    """)
    Page<LocationEntity> searchByCityOrDepartment(@Param("text") String text, Pageable pageable);
}
