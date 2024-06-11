package com.sergioruy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "item_ordered")
public class ItemOrdered {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "ordered_id")
    private Integer orderedId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    private Integer quantity;
}
