package com.steventk.jpastudy;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import junit.framework.Assert;

import org.junit.Test;

public class StudentCourseTest extends EntityManagerTest{

	@Test
	public void testPersist() {
		try{
			Student s1 = new Student();
			Student s2 = new Student();
			Course c1 = new Course();
			Course c2 = new Course();
			c1.setName("Database design");
			c2.setName("Java programming");
			s1.setName("Steven");
			s2.setName("Andrew");
			StudentCourse sc1 = new StudentCourse();
			StudentCourse sc2 = new StudentCourse();
			sc1.setStudent(s1);
			sc1.setCourse(c1);
			sc2.setStudent(s1);
			sc2.setCourse(c2);
			s1.getCourses().add(sc1);
			s1.getCourses().add(sc2);
			s2.getCourses().add(new StudentCourse(s2, c1));
			s2.getCourses().add(new StudentCourse(s2, c2));
			em.getTransaction().begin();
			em.persist(c1);
			em.persist(c2);
			em.persist(s1);
			em.persist(s2);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testJoinFetchAll() {
		try{
			testPersist();
			CriteriaBuilder cb = emf.getCriteriaBuilder();
			CriteriaQuery<Tuple> cq = cb.createTupleQuery();
			Root<Student> root = cq.from(Student.class);
			Root<Course> courseRoot = cq.from(Course.class);
			cq.multiselect(root, courseRoot);
			List<Tuple> resList = em.createQuery(cq).getResultList();
			for(Tuple s : resList){
				System.out.println(s.get(root).getId() +":"+s.get(root).getName()+":"+s.get(courseRoot).getId()+":"+s.get(courseRoot).getName());
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}
}
