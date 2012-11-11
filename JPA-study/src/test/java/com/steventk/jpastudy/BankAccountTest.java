package com.steventk.jpastudy;

import javax.persistence.EntityTransaction;

import junit.framework.Assert;

import org.junit.Test;

public class BankAccountTest extends EntityManagerTest{
    
    @Test
    public void testPersist() throws Exception {
        
        BankAccount ba = new BankAccount();
        ba.setAccount("768593");
        ba.setBankName("WEIKE LIU");
        ba.setSwift("CBA-125");
        ba.setOwner("Steven");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(ba);
        tx.commit();
        Assert.assertNotNull(ba.getId());
    }

}
