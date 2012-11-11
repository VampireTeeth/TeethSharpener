package com.steventk.jpastudy;

import javax.persistence.EntityTransaction;

import junit.framework.Assert;

import org.junit.Test;

public class UserAddressTest extends EntityManagerTest{
    
    @Test
    public void testUserAddressPersist() throws Exception {
        Address homeAddress = new Address();
        homeAddress.setStreet("Unit 6, 3 Riverview Street");
        homeAddress.setZipcode("2114");
        homeAddress.setCity("West Ryde");
        
        Address billingAddress = new Address();
        billingAddress.setStreet("28 Gloucester Street");
        billingAddress.setZipcode("2134");
        billingAddress.setCity("Rockdale");
        
        User user = new User();
        user.setFirstName("Steven");
        user.setLastName("Liu");
        user.setBillingAddress(billingAddress);
        user.setHomeAddress(homeAddress);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //Persists entities
        em.persist(user);
        tx.commit();
        
        Assert.assertNotNull(user.getId());
    }

}
