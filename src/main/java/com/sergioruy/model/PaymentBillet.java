package com.sergioruy.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "payment_billet")
public class PaymentBillet {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "ordered_id")
    private Integer orderedId;

    @Enumerated(EnumType.STRING)
    private StatusPayment status;

    @Column(name = "bar_code")
    private String barCode;
}
