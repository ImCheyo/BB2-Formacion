package com.example.bb2formacion.config;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.dto.SupplierDTO;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.model.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Supplier.class, SupplierDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getItems(), SupplierDTO::setItems);
                });

        return modelMapper;
    }
}
