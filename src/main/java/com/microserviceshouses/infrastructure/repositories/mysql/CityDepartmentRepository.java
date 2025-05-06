package com.microserviceshouses.infrastructure.repositories.mysql;


import com.microserviceshouses.infrastructure.entity.CityDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CityDepartmentRepository extends JpaRepository<CityDepartmentEntity, Long> {

    Optional<CityDepartmentEntity> findByName(String name);
    Optional<CityDepartmentEntity> findById(Long id);

}
