package com.example.bb2formacion.config;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.dto.SupplierDTO;
import com.example.bb2formacion.dto.UserDTO;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.model.Supplier;
import com.example.bb2formacion.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Item.class, ItemDTO.class)
                .addMappings(mapper -> {
                   mapper.map(src -> src.getUser(), ItemDTO::setUserDTO);
                   mapper.map(src -> src.getSuppliers(), ItemDTO::setSuppliersDTO);
                   mapper.map(src -> src.getReductions(), ItemDTO::setReductionsDTO);
                });

        return modelMapper;
    }
}
