package com.example.bb2formacion.dto;

import com.example.bb2formacion.enums.ItemStateEnum;
import com.example.bb2formacion.model.User;

import java.util.Date;

public class ItemDTO {

    private Long id;
    private String description;
    private Double price;
    private ItemStateEnum itemStateEnum;
    private Date create_At;
    private UserDTO userDTO;

    public ItemDTO(Long id, String description, Double price, ItemStateEnum itemStateEnum, Date create_At, UserDTO userDTO) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.itemStateEnum = itemStateEnum;
        this.create_At = create_At;
        this.userDTO = userDTO;
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
                ", userDTO=" + userDTO +
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
