package com.example.bb2formacion.fillters;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.dto.SupplierDTO;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.model.Supplier;
import com.example.bb2formacion.repository.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class Convert {

    @Autowired
    private SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;

    public Convert(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Item fromDtoToEntityItem(ItemDTO itemDTO){

        if( itemDTO == null){
            return null;
        }

        Item item = modelMapper.map(itemDTO, Item.class);

        return item;

    }

    public Supplier fromDtoToEntitySupplier(SupplierDTO supplierDTO){

        if( supplierDTO == null){
            return null;
        }

        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);

        return supplier;

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
}
