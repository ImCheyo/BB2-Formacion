package com.example.bb2formacion.repository;

import com.example.bb2formacion.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT nextval('item_code_seq')", nativeQuery = true)
    Integer getNextItemCode();

    Optional<Item> getItemByItemCode(Integer itemCode);
}
