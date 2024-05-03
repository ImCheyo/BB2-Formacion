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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Transactional
    @Override
    public Item createOrUpdateItem(Item item) {

        Set<Supplier> suppliers = new HashSet<>();
        Set<Reduction> reductions = new HashSet<>();

        if (item.getId() != null) {
            Item existingItem = itemRepository.findById(item.getId()).orElse(null);
            if (existingItem != null) {
                existingItem.setPrice(item.getPrice() != null ? item.getPrice() : null);
                existingItem.setDescription(item.getDescription() != null ? item.getDescription() : null);
                existingItem.setItemStateEnum(item.getItemStateEnum() != null ? item.getItemStateEnum(): null);

                if (item.getSuppliers() != null) {
                    for (Supplier supplier : item.getSuppliers()) {
                        Supplier existingSupplier = supplierRepository.findById(supplier.getId()).orElse(null);
                        if (existingSupplier == null) {
                            return null;//El supplier con ese id no existe
                        }
                        if(existingSupplier.equals(supplier)){
                            continue;
                        }
                        suppliers.add(existingSupplier);
                    }
                    existingItem.setSuppliers(suppliers);
                }

                if (item.getReductions() != null) {
                    for (Reduction reduction : item.getReductions()) {
                        Reduction existingReduction = reductionRepository.findById(reduction.getId()).orElse(null);
                        if (existingReduction == null) {
                            return null;//El reduction con ese id no existe
                        }
                        if(existingReduction.equals(reduction)){
                            continue;
                        }
                        reductions.add(existingReduction);
                    }
                    existingItem.setReductions(reductions);
                }

                User existingUser = userRepository.findById(existingItem.getUser().getId()).orElse(null);

                if (existingUser == null) {
                    return null;//El user con ese id no existe
                }

                existingItem.setUser(existingUser);

                for (Reduction reduction : existingItem.getReductions()) {
                    reduction.setItem(existingItem);
                    reductionRepository.save(reduction);
                }

                return itemRepository.save(existingItem);
            } else {
                return null; //No existe el item con ese ID
            }
        } else {

            if (item.getSuppliers() != null) {
                for (Supplier supplier : item.getSuppliers()) {
                    Supplier existingSupplier = supplierRepository.findById(supplier.getId()).orElse(null);
                    if (existingSupplier == null) {
                        return null;//El supplier con ese id no existe
                    }
                    suppliers.add(existingSupplier);
                }
                item.setSuppliers(suppliers);
            }

            if (item.getReductions() != null) {
                for (Reduction reduction : item.getReductions()) {
                    Reduction existingReduction = reductionRepository.findById(reduction.getId()).orElse(null);
                    if (existingReduction == null) {
                        return null;//El reduction con ese id no existe
                    }
                    reductions.add(existingReduction);
                }
                item.setReductions(reductions);
            }

            User existingUser = userRepository.findById(item.getUser().getId()).orElse(null);

            if (existingUser == null) {
                return null; //No existe el usuario con ese ID
            }

            item.setUser(existingUser);
            item.setItemStateEnum(ItemStateEnum.ACTIVE);

            itemRepository.save(item);

            for (Reduction reduction : item.getReductions()) {
                reduction.setItem(item);
                reductionRepository.save(reduction);
            }
            return item;
        }
    }

}
