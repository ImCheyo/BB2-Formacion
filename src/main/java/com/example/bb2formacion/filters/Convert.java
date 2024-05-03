package com.example.bb2formacion.filters;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.model.Item;
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

    public Item fromDtoToEntityItem(ItemDTO itemDTO){

        if( itemDTO == null){
            return null;
        }

        Item item = modelMapper.map(itemDTO, Item.class);

        return item;

    }

    public ItemDTO fromEntityToDtoItem(Item item){
        if (item == null){
            return null;
        }

        ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);

        return itemDTO;
    }

}
