package com.sergioruy.initwithjpa;

import com.sergioruy.EntityManagerTest;
import com.sergioruy.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionOperationsTest extends EntityManagerTest {

    @Test
    public void openAndCloseTransaction() {
        Product product = new Product(); // only for avoid error

        entityManager.getTransaction().begin(); // open

//        entityManager.persist(product);
//        entityManager.merge(product);
//        entityManager.remove(product);

        entityManager.getTransaction().commit(); // close
    }

    @Test
    public void firstInsert() {
        Product product = new Product();
        product.setId(2);
        product.setName("Camera Canon");
        product.setDescription("The best pictures for you.");
        product.setPrice(new BigDecimal(5000));

        entityManager.getTransaction().begin();

        entityManager.persist(product);

        entityManager.getTransaction().commit();

        entityManager.clear(); // remove from entity manager memory

        Product productVerification = entityManager.find(Product.class, product.getId());

        assertNotNull(productVerification);
    }

    @Test
    public void removeObject() {
        Product product = entityManager.find(Product.class, 3);

        entityManager.getTransaction().begin();

        entityManager.remove(product);

        entityManager.getTransaction().commit();

        Product productVerification = entityManager.find(Product.class, 3);

        assertNull(productVerification);
    }

    @Test
    public void updateObject() {
        // if you dont go to the database, you need set all properties, otherwise, all others properties will set as null.
        Product product = new Product();
        product.setName("Kindle Paperwhite");
        product.setDescription("The best reader.");
        product.setPrice(new BigDecimal(599));

        entityManager.getTransaction().begin();

        entityManager.merge(product);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productVerification = entityManager.find(Product.class, product.getId());

        assertNotNull(productVerification);
        assertEquals("Kindle Paperwhite", productVerification.getName());
    }

    @Test
    public void updateObjectManaged() {
        // Going to the database we can keep all the others properties and change only the one managed.
        Product product = entityManager.find(Product.class, 1);
        product.setName("Kindle Paperwhite 3rd generation");

        entityManager.getTransaction().begin();

        entityManager.merge(product);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productVerification = entityManager.find(Product.class, product.getId());

        assertNotNull(productVerification);
        assertEquals("Kindle Paperwhite 3rd generation", productVerification.getName());
    }

    @Test
    public void insertObjectWithMerge() {

        Product product = new Product();
        product.setId(4);
        product.setName("Microphone Rode");
        product.setDescription("Better sound quality.");
        product.setPrice(new BigDecimal(1000));

        entityManager.getTransaction().begin();

        entityManager.merge(product);

        entityManager.getTransaction().commit();

        entityManager.clear(); // remove from entity manager memory

        Product productVerification = entityManager.find(Product.class, product.getId());

        assertNotNull(productVerification);
    }

    @Test
    public void differenceBetweenPersistAndMerge() {

        Product productPersist = new Product();
        productPersist.setId(5);
        productPersist.setName("Smartphone One Plus");
        productPersist.setDescription("The must fast Android.");
        productPersist.setPrice(new BigDecimal(2000));

        entityManager.getTransaction().begin();

        entityManager.persist(productPersist); // dont need the return for keep working with the instance
        productPersist.setName("Smartphone Galaxy Note");

        entityManager.getTransaction().commit();

        entityManager.clear(); // remove from entity manager memory

        Product productVerificationPersisted = entityManager.find(Product.class, productPersist.getId());

        assertNotNull(productVerificationPersisted);

        // Merge also can used as a insert
        Product productMerge = new Product();
        productMerge.setId(6);
        productMerge.setName("Notebook Dell Alienware");
        productMerge.setDescription("Your games with you.");
        productMerge.setPrice(new BigDecimal(7000));

        entityManager.getTransaction().begin();

        productMerge = entityManager.merge(productMerge); // if you want keep working with the instance, you need the return
        productMerge.setName("Notebook Dell Alienware 14'");

        entityManager.getTransaction().commit();

        entityManager.clear(); // remove from entity manager memory

        Product productVerificationMerged = entityManager.find(Product.class, productMerge.getId());

        assertNotNull(productVerificationMerged);
    }
}
