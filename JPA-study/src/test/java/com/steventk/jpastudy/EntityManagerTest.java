package com.steventk.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class EntityManagerTest {

    private static final String EMF_NAME = "mydb-manager";
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @Before
    public void setUp() throws Exception {
        this.emf = Persistence.createEntityManagerFactory(EMF_NAME);
        this.em = this.emf.createEntityManager();
    }
    @Test
    public void testInstantiationOfEntityManager() throws Exception {
        Assert.assertNotNull(emf);
    }
    
    @Test
    public void testCategoryEntity() throws Exception {
        Category category = new Category();
        Assert.assertNotNull(emf);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(category);
        tx.commit();
        em.close();
        Assert.assertNotNull(category.getId());
        Assert.assertEquals(new Long(1), category.getId());
        Assert.assertNotNull(category.getLastModified());
    }
    
}
