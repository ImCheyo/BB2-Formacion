package com.example.bb2formacion.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="`reduction`")
public class Reduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reducedPrice;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;
}
