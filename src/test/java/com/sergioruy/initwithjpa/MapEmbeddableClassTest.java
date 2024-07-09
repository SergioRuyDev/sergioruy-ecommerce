package com.sergioruy.initwithjpa;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.AddressDeliveryOrdered;
import com.sergioruy.model.Customer;
import com.sergioruy.model.Ordered;
import com.sergioruy.model.StatusOrder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MapEmbeddableClassTest extends EntityManagerTest {


    @Test
    public void analyzeMapEmbeddableObjectTest() {
        AddressDeliveryOrdered address = new AddressDeliveryOrdered();
        address.setZipcode("00000-000");
        address.setCity("San Francisco");
        address.setState("CA");
        address.setDistrict("Sillicon Valley");
        address.setStreet("5ht avenue");
        address.setNumber("123");
        address.setComplement("square 4");

        Customer customer = entityManager.find(Customer.class, 1L);

        Ordered order = new Ordered();
        order.setDateOrdered(LocalDateTime.now());
        order.setStatus(StatusOrder.WAITING);
        order.setAmount(new BigDecimal("1000.00"));
        order.setAddressDelivery(address);
        order.setCustomer(customer);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Ordered verificationOrder = entityManager.find(Ordered.class, order.getId());
        assertNotNull(verificationOrder);
        assertNotNull(verificationOrder.getAddressDelivery());
        assertNotNull(verificationOrder.getAddressDelivery().getZipcode());
        assertNotNull(verificationOrder.getAddressDelivery().getCity());
    }
}
