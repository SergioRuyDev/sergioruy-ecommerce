package com.sergioruy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Invoice {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer orderedId;

    private String xml;

    private Date dateEmission;
}
