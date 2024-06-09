package com.sergioruy.initwithjpa;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsultRegisterTest extends EntityManagerTest {

    @Test
    public void consultRegister() {
        Product product = entityManager.find(Product.class, 1);
//        Product product = entityManager.getReference(Product.class, 1);

        assertNotNull(product);
        assertEquals("Kindle", product.getName());
    }

    @Test
    public void updateReference() {
        Product product = entityManager.find(Product.class, 1);

        product.setName("Microphone Samson");
        entityManager.refresh(product);

        assertEquals("Kindle", product.getName());
    }
}
