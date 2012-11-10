package com.steventk.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Test;

public class EntityManagerTest {

    private static final String EMF_NAME = "mydb-manager";
    @Test
    public void testInstantiationOfEntityManager() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMF_NAME);
        Assert.assertNotNull(emf);
    }
    
    @Test
    public void testCategoryEntity() throws Exception {
        Category category = new Category();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMF_NAME);
        Assert.assertNotNull(emf);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(category);
        tx.commit();
        em.close();
        Assert.assertEquals(new Long(1), category.getId());
    }
}
