package com.example.bb2formacion.controller;

import com.example.bb2formacion.dto.ReductionDTO;
import com.example.bb2formacion.filters.Convert;
import com.example.bb2formacion.model.Reduction;
import com.example.bb2formacion.service.ReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
@RequestMapping("/api/reductions")
public class ReductionController {

    @Autowired
    private ReductionService reductionService;

    @Autowired
    private Convert convert;

    @GetMapping
    public List<ReductionDTO> getAllItems(){
        List<Reduction> reductions = reductionService.getAllItems();

        List<ReductionDTO> reductionsDTO = new ArrayList<>();

        for(Reduction reduction : reductions){
            ReductionDTO reductionDTO = convert.fromEntityToDtoReduction(reduction);
            reductionsDTO.add(reductionDTO);
        }

        return reductionsDTO;
    }
}
