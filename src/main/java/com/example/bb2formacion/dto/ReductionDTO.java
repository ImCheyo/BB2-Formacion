package com.example.bb2formacion.dto;

import java.util.Date;
import java.util.Set;

public class ReductionDTO {

    private Long id;
    private Double reducedPrice;
    private Date startDate;
    private Date endDate;

    public ReductionDTO(Long id, Double reducedPrice, Date startDate, Date endDate) {
        this.id = id;
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ReductionDTO(){

    }

    @Override
    public String toString() {
        return "ReductionDTO{" +
                "id=" + id +
                ", reducedPrice=" + reducedPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
