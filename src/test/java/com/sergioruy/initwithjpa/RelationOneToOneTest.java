package com.sergioruy.initwithjpa;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.*;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RelationOneToOneTest extends EntityManagerTest {

    @Test
    public void verifyRelationOrderedAndPaymentCardTest() {

        Ordered order = entityManager.find(Ordered.class, 1L);

        PaymentCard card = new PaymentCard();
        card.setDigits("1234");
        card.setStatus(StatusPayment.PROCESSING);
        card.setOrdered(order);

        entityManager.getTransaction().begin();
        entityManager.persist(card);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Ordered orderVerification = entityManager.find(Ordered.class, order.getId());
        assertNotNull(orderVerification.getPayment());
    }

    @Test
    public void verifyRelationOrderedAndInvoiceTest() {

        Ordered order = entityManager.find(Ordered.class, 1L);

        Invoice invoice = new Invoice();
        invoice.setOrdered(order);
        invoice.setXml("TEST");
        invoice.setDateEmission(new Date());

        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Ordered orderVerification = entityManager.find(Ordered.class, order.getId());
        assertNotNull(orderVerification.getInvoice());
    }
}
