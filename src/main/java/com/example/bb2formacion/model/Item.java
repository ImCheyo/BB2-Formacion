package com.example.bb2formacion.model;

import com.example.bb2formacion.enums.ItemStateEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="`item`")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Double price;

    @Enumerated(EnumType.STRING)
    private ItemStateEnum itemStateEnum;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "item_suppliers",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    @JsonIgnore
    private Set<Supplier> suppliers;

    @OneToMany(mappedBy = "item")
    private Set<Reduction> reductions;

    @CreationTimestamp
    private Date create_At;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Item(Long id, String description, Double price, ItemStateEnum itemStateEnum, Set<Supplier> suppliers, Set<Reduction> reductions, Date create_At, User user) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.itemStateEnum = itemStateEnum;
        this.suppliers = suppliers;
        this.reductions = reductions;
        this.create_At = create_At;
        this.user = user;
    }

    public Item(){

    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", itemStateEnum=" + itemStateEnum +
                ", suppliers=" + suppliers +
                ", reductions=" + reductions +
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

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<Reduction> getReductions() {
        return reductions;
    }

    public void setReductions(Set<Reduction> reductions) {
        this.reductions = reductions;
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
