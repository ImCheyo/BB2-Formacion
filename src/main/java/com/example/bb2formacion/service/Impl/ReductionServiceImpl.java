package com.example.bb2formacion.service.Impl;

import com.example.bb2formacion.model.Reduction;
import com.example.bb2formacion.repository.ReductionRepository;
import com.example.bb2formacion.service.ReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReductionServiceImpl implements ReductionService {

    @Autowired
    private ReductionRepository reductionRepository;

    @Override
    public List<Reduction> getAllItems() {
        return reductionRepository.findAll();
    }

    @Override
    public Optional<Reduction> getReductionByReductionCode(Integer reductionCode) {
        return reductionRepository.getReductionByReductionCode(reductionCode);
    }
}
