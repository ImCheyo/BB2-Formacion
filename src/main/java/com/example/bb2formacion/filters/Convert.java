package com.example.bb2formacion.filters;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.dto.ReductionDTO;
import com.example.bb2formacion.dto.SupplierDTO;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.model.Reduction;
import com.example.bb2formacion.model.Supplier;
import com.example.bb2formacion.repository.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Convert {

    @Autowired
    private SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;

    public Convert(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ItemDTO fromEntityToDtoItem(Item item){
        if (item == null){
            return null;
        }

        ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);

        return itemDTO;
    }

    public SupplierDTO fromEntityToDtoSupplier(Supplier supplier){
        if (supplier == null){
            return null;
        }

        SupplierDTO supplierDTO = modelMapper.map(supplier, SupplierDTO.class);

        return supplierDTO;
    }

    public ReductionDTO fromEntityToDtoReduction(Reduction reduction){
        if (reduction == null){
            return null;
        }

        ReductionDTO reductionDTO = modelMapper.map(reduction, ReductionDTO.class);

        return reductionDTO;
    }

}
