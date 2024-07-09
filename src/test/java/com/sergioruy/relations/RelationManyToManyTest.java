package com.sergioruy.relations;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RelationManyToManyTest extends EntityManagerTest {

    @Test
    public void verifyRelation() {

        Product product = entityManager.find(Product.class, 1L);
        Category category = entityManager.find(Category.class, 1L);

        entityManager.getTransaction().begin();
//        category.setProducts(Arrays.asList(product)); not work, because category is not owner
        product.setCategories(Arrays.asList(category)); // owner of relation
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category categoryVerification = entityManager.find(Category.class, 1L);
        assertFalse(categoryVerification.getProducts().isEmpty());
    }
}
