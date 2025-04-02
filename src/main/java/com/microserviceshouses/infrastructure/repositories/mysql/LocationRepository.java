package com.microserviceshouses.infrastructure.repositories.mysql;

import com.microserviceshouses.infrastructure.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<LocationEntity, Long> {


}
