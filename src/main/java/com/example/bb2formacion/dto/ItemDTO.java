package com.example.bb2formacion.dto;

import com.example.bb2formacion.enums.ItemStateEnum;
import com.example.bb2formacion.model.User;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ItemDTO {

    private Long id;
    private String description;
    private Double price;
    private ItemStateEnum itemStateEnum;
    private Date create_At;
    private User user;

    public ItemDTO(Long id, String description, Double price, ItemStateEnum itemStateEnum, Date create_At, User user) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.itemStateEnum = itemStateEnum;
        this.create_At = create_At;
        this.user = user;
    }

    public ItemDTO(){

    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", itemStateEnum=" + itemStateEnum +
                ", create_At=" + create_At +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemStateEnum getItemStateEnum() {
        return itemStateEnum;
    }

    public void setItemStateEnum(ItemStateEnum itemStateEnum) {
        this.itemStateEnum = itemStateEnum;
    }

    public Date getCreate_At() {
        return create_At;
    }

    public void setCreate_At(Date create_At) {
        this.create_At = create_At;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
