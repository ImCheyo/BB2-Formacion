package com.example.bb2formacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="`supplier`")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_code", unique = true)
    private Integer supplierCode;

    private String name;
    private String country;

    @ManyToMany(mappedBy = "suppliers")
    @JsonIgnore
    private Set<Item> items;

    public Supplier(Long id, Integer supplierCode, String name, String country, Set<Item> items) {
        this.id = id;
        this.supplierCode = supplierCode;
        this.name = name;
        this.country = country;
        this.items = items;
    }

    public Supplier(){

    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplierCode=" + supplierCode +
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

    public Integer getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(Integer supplierCode) {
        this.supplierCode = supplierCode;
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
