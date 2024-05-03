package com.example.bb2formacion.controller;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.filters.Convert;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Convert convert;

    @GetMapping
    public List<ItemDTO> getAllItems(){
        List<Item> items = itemService.getAllItems();

        List<ItemDTO> itemsDTO = new ArrayList<>();

        for(Item item : items){
            ItemDTO itemDTO = convert.fromEntityToDtoItem(item);
            itemsDTO.add(itemDTO);
        }

        return itemsDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id){
        Item item = itemService.getItemById(id).orElse(null);

        ItemDTO itemDTO = convert.fromEntityToDtoItem(item);

        return ResponseEntity.status(HttpStatus.OK).body(itemDTO);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createOrUpdateItem(@RequestBody Item item){

        Item newItem = itemService.createOrUpdateItem(item);

        ItemDTO itemDTO = convert.fromEntityToDtoItem(newItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemDTO);
    }

}
