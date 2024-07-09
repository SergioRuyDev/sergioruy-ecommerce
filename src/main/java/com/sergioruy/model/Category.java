package com.sergioruy.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "category")
public class Category {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_higher_id")
    private Category categoryHigher;

    @OneToMany(mappedBy = "categoryHigher")
    private List<Category> subCategories;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;
}
