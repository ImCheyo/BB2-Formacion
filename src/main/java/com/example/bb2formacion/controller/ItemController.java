package com.example.bb2formacion.controller;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ItemDTO> getAllItems(){
        List<Item> items = itemService.getAllItems();
        return items.stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

}
