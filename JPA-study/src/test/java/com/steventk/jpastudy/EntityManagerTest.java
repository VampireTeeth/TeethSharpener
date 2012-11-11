package com.steventk.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityManagerTest {

    protected static final String EMF_NAME = "mydb-manager";
    
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    
    @BeforeClass
    public static void beforeClassSetUp() throws Exception {
        emf = Persistence.createEntityManagerFactory(EMF_NAME);
    }
    
    @Before 
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() throws Exception {
        em.close();
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
        Assert.assertNotNull(category.getId());
        Assert.assertNotNull(category.getLastModified());
    }
    
}
