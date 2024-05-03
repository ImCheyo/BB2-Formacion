package com.example.bb2formacion.repository;

import com.example.bb2formacion.model.Reduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReductionRepository extends JpaRepository<Reduction, Long> {
}
