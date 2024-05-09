package com.example.bb2formacion.controller;

import com.example.bb2formacion.dto.SupplierDTO;
import com.example.bb2formacion.filters.Convert;
import com.example.bb2formacion.model.Supplier;
import com.example.bb2formacion.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private Convert convert;

    @GetMapping
    public List<SupplierDTO> getAllItems(){
        List<Supplier> suppliers = supplierService.getAllItems();

        List<SupplierDTO> suppliersDTO = new ArrayList<>();

        for(Supplier supplier : suppliers){
            SupplierDTO supplierDTO = convert.fromEntityToDtoSupplier(supplier);
            suppliersDTO.add(supplierDTO);
        }

        return suppliersDTO;
    }
}
