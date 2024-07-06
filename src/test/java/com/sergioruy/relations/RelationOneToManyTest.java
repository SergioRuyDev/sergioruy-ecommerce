package com.sergioruy.relations;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RelationOneToManyTest extends EntityManagerTest {

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

        Customer customerVerification = entityManager.find(Customer.class, customer.getId());
        assertFalse(customerVerification.getOrders().isEmpty());
    }

    @Test
    public void verifyRelationitemOrdered() {

        Customer customer = entityManager.find(Customer.class, 1L);
        Product product = entityManager.find(Product.class, 1L);

        Ordered ordered = new Ordered();
        ordered.setStatus(StatusOrder.WAITING);
        ordered.setDateOrdered(LocalDateTime.now());
        ordered.setAmount(BigDecimal.TEN);
        ordered.setCustomer(customer);

        ItemOrdered item = new ItemOrdered();
        item.setOrdered(ordered);
        item.setProduct(product);
        item.setProductPrice(product.getPrice());
        item.setQuantity(1);


        entityManager.getTransaction().begin();
        entityManager.persist(ordered);
        entityManager.persist(item);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemOrdered itemVerification = entityManager.find(ItemOrdered.class, item.getId());
        Ordered orderedVerification = entityManager.find(Ordered.class, ordered.getId());

        assertFalse(itemVerification.getOrdered().getItems().isEmpty());
        assertFalse(orderedVerification.getItems().isEmpty());
    }
}
