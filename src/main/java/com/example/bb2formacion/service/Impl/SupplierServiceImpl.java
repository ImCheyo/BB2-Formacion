package com.example.bb2formacion.service.Impl;

import com.example.bb2formacion.model.Supplier;
import com.example.bb2formacion.repository.SupplierRepository;
import com.example.bb2formacion.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllItems() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> getSupplierBySupplierCode(Integer supplierCode) {
        return supplierRepository.getSupplierBySupplierCode(supplierCode);
    }
}
