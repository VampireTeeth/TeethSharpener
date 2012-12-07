package com.steventk.jpastudy;

import org.junit.Test;


public class AssignedIdEntityTest extends EntityManagerTest{
	
	@Test
	public void testDetach() throws Exception {
		AssignedIdEntity entity = new AssignedIdEntity();
		entity.setId(1L);
		entity.setName("TEST_NAME");
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		
		entity = em.find(AssignedIdEntity.class, 1L);
		em.getTransaction().begin();
		em.remove(entity);
		em.detach(entity);
		entity.setId(2L);
		em.persist(entity);
		
		em.getTransaction().commit();
	}
}
