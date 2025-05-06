package com.microserviceshouses.infrastructure.repositories.mysql;

import com.microserviceshouses.infrastructure.entity.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    @Query("SELECT l, c.name AS cityName, d.name AS departmentName " +
            "FROM LocationEntity l " +
            "JOIN l.city c " +
            "JOIN c.cityDepartment d " +
            "WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "OR LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Object[]> findByCityNameOrDepartmentNameWithPagination(@Param("name") String name, Pageable pageable);

}
