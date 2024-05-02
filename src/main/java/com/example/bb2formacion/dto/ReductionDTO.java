package com.example.bb2formacion.dto;

import java.util.Set;

public class ReductionDTO {

    private Long id;
    private String name;
    private String country;
    private Set<ItemDTO> items;

    public ReductionDTO(Long id, String name, String country, Set<ItemDTO> items) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.items = items;
    }

    public ReductionDTO(){

    }

    @Override
    public String toString() {
        return "ReductionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", items=" + items +
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

    public Set<ItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<ItemDTO> items) {
        this.items = items;
    }
}
