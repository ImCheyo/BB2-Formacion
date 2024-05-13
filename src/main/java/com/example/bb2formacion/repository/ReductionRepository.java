package com.example.bb2formacion.repository;

import com.example.bb2formacion.model.Reduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReductionRepository extends JpaRepository<Reduction, Long> {
    @Query(value = "SELECT nextval('reduction_code_seq')", nativeQuery = true)
    Integer getNextReductionCode();

    Optional<Reduction> getReductionByReductionCode(Integer reductionCode);
}
