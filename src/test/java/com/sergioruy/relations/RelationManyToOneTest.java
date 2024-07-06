package com.sergioruy.relations;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationManyToOneTest extends EntityManagerTest {

    @Test
    public void verifyRelation() {

        Customer customer = entityManager.find(Customer.class, 1L);

        Ordered ordered = new Ordered();
        ordered.setStatus(StatusOrder.WAITING);
        ordered.setDateOrdered(LocalDateTime.now());
        ordered.setAmount(BigDecimal.TEN);

         ordered.setCustomer(customer);

         entityManager.getTransaction().begin();
         entityManager.persist(ordered);
         entityManager.getTransaction().commit();

         entityManager.clear();

         Ordered newOrdered = entityManager.find(Ordered.class, ordered.getId());
        Assertions.assertNotNull(newOrdered);
    }

    @Test
    public void verifyRelationItemOrdered() {

        Customer customer = entityManager.find(Customer.class, 1L);
        Product product = entityManager.find(Product.class, 1L);

        Ordered ordered = new Ordered();
        ordered.setStatus(StatusOrder.WAITING);
        ordered.setDateOrdered(LocalDateTime.now());
        ordered.setAmount(BigDecimal.TEN);
        ordered.setCustomer(customer);

        ItemOrdered itemOrdered = new ItemOrdered();
        itemOrdered.setProductPrice(product.getPrice());
        itemOrdered.setQuantity(1);
        itemOrdered.setOrdered(ordered);
        itemOrdered.setProduct(product);



         entityManager.getTransaction().begin();
         entityManager.persist(ordered);
         entityManager.persist(itemOrdered);
         entityManager.getTransaction().commit();

         entityManager.clear();

        ItemOrdered itemOrderedVerification = entityManager.find(ItemOrdered.class, itemOrdered.getId());
        Assertions.assertNotNull(itemOrderedVerification.getOrdered());
        Assertions.assertNotNull(itemOrderedVerification.getProduct());
    }
}
