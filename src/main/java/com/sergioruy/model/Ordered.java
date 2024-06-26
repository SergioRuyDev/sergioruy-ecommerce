package com.sergioruy.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ordered")
public class Ordered {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_ordered")
    private LocalDateTime dateOrdered;

    @Column(name = "date_conclusion")
    private LocalDateTime dateConclusion;

    @Column(name = "invoice_id")
    private Integer invoiceId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private StatusOrder status;

    @Embedded
    private AddressDeliveryOrdered addressDelivery;
}
