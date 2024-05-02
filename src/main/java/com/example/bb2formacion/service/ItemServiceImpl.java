package com.example.bb2formacion.service;

import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }
}
