package com.example.bb2formacion.controller;

import com.example.bb2formacion.dto.ItemDTO;
import com.example.bb2formacion.filters.Convert;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

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

    @GetMapping("/{itemCode}")
    public ResponseEntity<ItemDTO> getItemByItemCode(@PathVariable Integer itemCode){
        Item item = itemService.getItemByItemCode(itemCode).orElse(null);

        ItemDTO itemDTO = convert.fromEntityToDtoItem(item);

        return ResponseEntity.status(HttpStatus.OK).body(itemDTO);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createOrUpdateItem(@RequestBody Item item){

        Item newItem = itemService.createItem(item);

        ItemDTO itemDTO = convert.fromEntityToDtoItem(newItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemDTO);
    }

    @PutMapping("/{itemCode}")
    public ResponseEntity<ItemDTO> update(@PathVariable Integer itemCode, @RequestBody Item item){
        Item updatedItem = itemService.updateItem(itemCode, item);

        ItemDTO itemDTO = convert.fromEntityToDtoItem(updatedItem);

        return ResponseEntity.status(HttpStatus.OK).body(itemDTO);
    }

}
