package com.microserviceshouses.infrastructure.repositories.mysql;

import com.microserviceshouses.infrastructure.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

    Optional<CityEntity> findById(Long id);

}
