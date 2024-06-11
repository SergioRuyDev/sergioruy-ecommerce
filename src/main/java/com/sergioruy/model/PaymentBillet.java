package com.sergioruy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PaymentBillet {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer orderedId;

    private StatusPayment status;

    private String barCode;
}