package com.example.bb2formacion.service;

import com.example.bb2formacion.model.Reduction;

import java.util.List;
import java.util.Optional;

public interface ReductionService {
    List<Reduction> getAllItems();
    Optional<Reduction> getReductionByReductionCode(Integer reductionCode);
}
