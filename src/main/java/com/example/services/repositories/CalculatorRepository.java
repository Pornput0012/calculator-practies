package com.example.services.repositories;

import com.example.services.entities.CalculatorLog;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface CalculatorRepository extends JpaRepository<CalculatorLog, Integer> {
    List<CalculatorLog> findByOperation(String operation);
}
