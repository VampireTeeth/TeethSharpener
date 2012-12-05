package com.steventk.jpastudy;

import org.junit.Test;

public class BeanWithCompositeKeyTest extends EntityManagerTest{

	
	@Test
	public void testPersist() throws Exception {
		BeanWithCompositeKey bean = new BeanWithCompositeKey();
		bean.setKey1(123L);
		bean.setKey2(345L);
		em.getTransaction().begin();
		em.persist(bean);
		em.getTransaction().commit();
	}
}
