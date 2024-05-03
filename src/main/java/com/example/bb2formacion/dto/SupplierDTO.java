package com.example.bb2formacion.dto;

import java.util.Set;

public class SupplierDTO {

    private Long id;
    private String name;
    private String country;

    public SupplierDTO(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public SupplierDTO(){

    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
