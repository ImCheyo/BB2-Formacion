package com.example.bb2formacion.service;

import com.example.bb2formacion.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> getAllItems();
    Optional<Supplier> getSupplierBySupplierCode(Integer supplierCode);
}
