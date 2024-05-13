package com.example.bb2formacion.dto;

import com.example.bb2formacion.enums.ItemStateEnum;

import java.util.Date;
import java.util.Set;

public class ItemDTO {

    private Long id;
    private Integer itemCode;
    private String description;
    private Double price;
    private ItemStateEnum itemStateEnum;
    private Date create_At;
    private Set<SupplierDTO> suppliersDTO;
    private Set<ReductionDTO> reductionsDTO;
    private UserDTO userDTO;

    public ItemDTO(Long id, Integer itemCode, String description, Double price, ItemStateEnum itemStateEnum, Date create_At, Set<SupplierDTO> suppliersDTO, Set<ReductionDTO> reductionsDTO, UserDTO userDTO) {
        this.id = id;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.itemStateEnum = itemStateEnum;
        this.create_At = create_At;
        this.suppliersDTO = suppliersDTO;
        this.reductionsDTO = reductionsDTO;
        this.userDTO = userDTO;
    }

    public ItemDTO(){

    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", itemCode=" + itemCode +
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

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
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

    public Set<SupplierDTO> getSuppliersDTO() {
        return suppliersDTO;
    }

    public void setSuppliersDTO(Set<SupplierDTO> suppliersDTO) {
        this.suppliersDTO = suppliersDTO;
    }

    public Set<ReductionDTO> getReductionsDTO() {
        return reductionsDTO;
    }

    public void setReductionsDTO(Set<ReductionDTO> reductionsDTO) {
        this.reductionsDTO = reductionsDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
