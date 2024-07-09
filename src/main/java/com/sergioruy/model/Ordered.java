package com.sergioruy.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "customer_id") // also can be changed for fetch = Lazy
    private Customer customer;

    @OneToMany(mappedBy = "ordered") // pattern can change to bring automatic , fetch = FetchType.EAGER
    private List<ItemOrdered> items;

    @Column(name = "date_ordered")
    private LocalDateTime dateOrdered;

    @Column(name = "date_conclusion")
    private LocalDateTime dateConclusion;

    @OneToOne(mappedBy = "ordered")
    private Invoice invoice;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private StatusOrder status;

    @OneToOne(mappedBy = "ordered")
    private PaymentCard payment;

    @Embedded
    private AddressDeliveryOrdered addressDelivery;
}
