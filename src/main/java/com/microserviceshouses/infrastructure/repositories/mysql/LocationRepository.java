package com.microserviceshouses.infrastructure.repositories.mysql;

import com.microserviceshouses.infrastructure.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LocationRepository extends JpaRepository<LocationEntity, UUID> {


}
