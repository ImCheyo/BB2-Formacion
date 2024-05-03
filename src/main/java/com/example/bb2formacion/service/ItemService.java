package com.example.bb2formacion.service;

import com.example.bb2formacion.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getAllItems();
    Optional<Item> getItemById(Long id);
    Item createOrUpdateItem(Item item);

}
