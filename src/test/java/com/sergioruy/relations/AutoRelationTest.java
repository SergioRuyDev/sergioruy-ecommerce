package com.sergioruy.relations;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AutoRelationTest extends EntityManagerTest {

    @Test
    public void verifyRelation() {
        Category categoryDad = new Category();
        categoryDad.setName("Eletronics");

        Category categoryChildren = new Category();
        categoryChildren.setName("Mobile");
        categoryChildren.setCategoryHigher(categoryDad);

        entityManager.getTransaction().begin();
        entityManager.persist(categoryDad);
        entityManager.persist(categoryChildren);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category categoryVerification = entityManager.find(Category.class, categoryChildren.getId());
        assertNotNull(categoryVerification.getCategoryHigher());

        Category categoryDadVerification = entityManager.find(Category.class, categoryDad.getId());
        assertFalse(categoryDadVerification.getSubCategories().isEmpty());
    }
}
