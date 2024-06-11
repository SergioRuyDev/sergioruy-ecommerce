package com.sergioruy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Ordered {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private LocalDateTime dateOrdered;

    private LocalDateTime dateConclusion;

    private Integer invoiceId;

    private BigDecimal amount;

    private StatusOrder status;
}
