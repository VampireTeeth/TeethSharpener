package com.steventk.jpastudy;

import java.util.List;

import javax.persistence.EntityManager;

public class StudentDao {

	private final EntityManager em;
	
	public StudentDao(EntityManager em) {
		this.em = em;
	}
	
	List<Student> findAllWithCourses() {
		String jpql = 
				"select distinct s from Student s " +
				"join fetch s.courses sc " +
				"join fetch sc.pk.course c " + 
				"order by s.id"
				;
		return em.createQuery(jpql, Student.class).getResultList();
	}
}
