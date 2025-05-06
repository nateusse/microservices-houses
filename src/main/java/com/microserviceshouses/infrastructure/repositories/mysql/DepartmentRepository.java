package com.microserviceshouses.infrastructure.repositories.mysql;

import com.microserviceshouses.infrastructure.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {}