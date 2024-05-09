package com.example.bb2formacion.service.Impl;

import com.example.bb2formacion.enums.ItemStateEnum;
import com.example.bb2formacion.model.Item;
import com.example.bb2formacion.model.Reduction;
import com.example.bb2formacion.model.Supplier;
import com.example.bb2formacion.model.User;
import com.example.bb2formacion.repository.ItemRepository;
import com.example.bb2formacion.repository.ReductionRepository;
import com.example.bb2formacion.repository.SupplierRepository;
import com.example.bb2formacion.repository.UserRepository;
import com.example.bb2formacion.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ReductionRepository reductionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Optional<Item> getItemByItemCode(Integer itemCode) {
        return itemRepository.getItemByItemCode(itemCode);
    }

    @Transactional
    @Override
    public Item createItem(Item item) {

        Set<Supplier> suppliers = new HashSet<>();
        Set<Reduction> reductions = new HashSet<>();

            if (item.getSuppliers() != null) {
                for (Supplier supplier : item.getSuppliers()) {
                    Supplier existingSupplier = supplierRepository.getSupplierBySupplierCode(supplier.getSupplierCode()).orElse(null);
                    if (existingSupplier == null) {
                        return null;//El supplier con ese id no existe
                    }
                    suppliers.add(existingSupplier);
                }
                item.setSuppliers(suppliers);
            }

            if (item.getReductions() != null) {
                for (Reduction reduction : item.getReductions()) {
                    Reduction existingReduction = reductionRepository.getReductionByReductionCode(reduction.getReductionCode()).orElse(null);
                    if (existingReduction == null) {
                        return null;//El reduction con ese id no existe
                    }
                    reductions.add(existingReduction);
                }
                item.setReductions(reductions);
            }

            User existingUser = userRepository.getUserByUserCode(item.getUser().getUserCode()).orElse(null);

            if (existingUser == null) {
                return null; //No existe el usuario con ese ID
            }

            item.setUser(existingUser);
            item.setItemStateEnum(ItemStateEnum.ACTIVE);
            item.setItemCode(itemRepository.getNextItemCode());

            itemRepository.save(item);

            for (Reduction reduction : item.getReductions()) {
                reduction.setItem(item);
                reductionRepository.save(reduction);
            }
            return item;

    }

    @Transactional
    @Override
    public Item updateItem(Integer itemCode, Item item){

        Set<Supplier> suppliers = new HashSet<>();
        Set<Reduction> reductions = new HashSet<>();

            Item existingItem = itemRepository.getItemByItemCode(itemCode).orElse(null);
            if (existingItem != null) {
                existingItem.setPrice(item.getPrice() != null ? item.getPrice() : null);
                existingItem.setDescription(item.getDescription() != null ? item.getDescription() : null);
                existingItem.setItemStateEnum(item.getItemStateEnum() != null ? item.getItemStateEnum(): null);

                if (item.getSuppliers() != null) {
                    for (Supplier supplier : item.getSuppliers()) {
                        Supplier existingSupplier = supplierRepository.getSupplierBySupplierCode(supplier.getSupplierCode()).orElse(null);
                        if (existingSupplier == null) {
                            return null;//El supplier con ese id no existe
                        }
                        suppliers.add(existingSupplier);
                    }
                    existingItem.setSuppliers(suppliers);
                }

                for (Reduction reduction : existingItem.getReductions()){
                    if(!item.getReductions().contains(reduction)){
                        reduction.setItem(null);
                        reductionRepository.save(reduction);
                    }
                }

                for (Reduction reduction : item.getReductions()){
                    Reduction existingReduction = reductionRepository.getReductionByReductionCode(reduction.getReductionCode()).orElse(null);
                    if(existingReduction == null){
                        return null; //El reduction con ese codigo no existe
                    }
                    existingReduction.setItem(existingItem);
                    reductionRepository.save(existingReduction);
                }

                existingItem.setReductions(new HashSet<>(item.getReductions()));

                User existingUser = userRepository.getUserByUserCode(item.getUser().getUserCode()).orElse(null);

                if (existingUser == null) {
                    return null;//El user con ese id no existe
                }

                existingItem.setUser(existingUser);

                existingItem.setCreate_At(existingItem.getCreate_At());
                existingItem.setItemCode(existingItem.getItemCode());

                return itemRepository.save(existingItem);
            } else {
                return null; //No existe el item con ese ID
            }

    }

}
