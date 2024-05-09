package com.example.bb2formacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="`reduction`")
public class Reduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reduction_code", unique = true)
    private Integer reductionCode;

    private Double reducedPrice;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="item_id")
    @JsonIgnore
    private Item item;

    public Reduction(Long id, Integer reductionCode, Double reducedPrice, Date startDate, Date endDate, Item item) {
        this.id = id;
        this.reductionCode = reductionCode;
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.item = item;
    }

    public Reduction(){

    }

    @Override
    public String toString() {
        return "Reduction{" +
                "id=" + id +
                ", reductionCode=" + reductionCode +
                ", reducedPrice=" + reducedPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", item=" + item +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReductionCode() {
        return reductionCode;
    }

    public void setReductionCode(Integer reductionCode) {
        this.reductionCode = reductionCode;
    }

    public Double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
