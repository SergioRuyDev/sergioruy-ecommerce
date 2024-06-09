package com.sergioruy.initwithjpa;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstCrudTest extends EntityManagerTest {

    @Test
    public void insertCustomer() {

        Customer customer = new Customer();
        customer.setId(3);
        customer.setName("Dora Coutinho");

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Customer customerVerification = entityManager.find(Customer.class, customer.getId());
        assertNotNull(customerVerification);
    }

    @Test
    public void selectCustomer() {

        Customer consultCustomer = entityManager.find(Customer.class, 1);
        assertNotNull(consultCustomer);
        assertEquals("Sergio Ruy", consultCustomer.getName());
    }

    @Test
    public void updateCustomer() {
        Customer mergeCustomer = entityManager.find(Customer.class, 1);
        mergeCustomer.setName("Mark Grayson");

        entityManager.getTransaction().begin();
        entityManager.merge(mergeCustomer);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Customer mergedCustomerVerification = entityManager.find(Customer.class, mergeCustomer.getId());
        assertNotNull(mergedCustomerVerification);
        assertEquals("Mark Grayson", mergedCustomerVerification.getName());
        assertEquals(1, mergedCustomerVerification.getId());
    }

    @Test
    public void deleteCustomer() {
        Customer deletedCustomer = entityManager.find(Customer.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(deletedCustomer);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Customer deletedCustomerVerification = entityManager.find(Customer.class, deletedCustomer.getId());
        assertNull(deletedCustomerVerification);
    }
}
