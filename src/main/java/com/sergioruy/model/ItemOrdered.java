package com.sergioruy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemOrdered {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer orderedId;

    private Integer productId;

    private BigDecimal productPrice;

    private Integer quantity;
}