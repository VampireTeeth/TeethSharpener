package com.steventk.jpastudy;

import javax.persistence.EntityTransaction;

import junit.framework.Assert;

import org.junit.Test;

public class CreditCardTest extends EntityManagerTest{

    @Test
    public void testPersistCreditCard() throws Exception {
        CreditCard cc = new CreditCard();
        cc.setNumber("12345678");
        cc.setExpMonth("May");
        cc.setExpYear("2014");
        cc.setOwner("Steven");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cc);
        tx.commit();
        Assert.assertNotNull(cc.getId());
    }
}
