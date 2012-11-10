package com.steventk.jpastudy;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Test;

public class EntityManagerTest {

    @Test
    public void testInstantiationOfEntityManager() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb-manager");
        Assert.assertNotNull(emf);
    }
}
