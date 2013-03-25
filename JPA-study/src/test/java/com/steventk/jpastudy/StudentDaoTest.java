package com.steventk.jpastudy;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class StudentDaoTest {

	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private StudentDao dao;
	private Student s1;
	private Student s2;
	private Course c1;
	private Course c2;
	private StudentCourse s1c1;
	private StudentCourse s1c2;
	private StudentCourse s2c1;
	private StudentCourse s2c2;
	private Student s3;
	private EntityManager transactionalEm;
	
	@BeforeClass
	public static void beforeClass() {
		String persistenceUnitName = "mydb-manager";
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	}
	
	@Before
	public void before() {
		em = emf.createEntityManager();
		dao = new StudentDao(em);
		transactionalEm = emf.createEntityManager();
		persistsData();
	}
	
	@After
	public void after() {
		removeData();
		em.close();
	}
	
	private void removeData() {
		transactionalEm.getTransaction().begin();
		transactionalEm.createQuery("delete from StudentCourse")
			.executeUpdate();
		transactionalEm.createQuery("delete from Student")
			.executeUpdate();
		transactionalEm.createQuery("delete from Course")
			.executeUpdate();

		transactionalEm.getTransaction().commit();
	}

	@Test
	public void testFindStudentsWithCourses() throws Exception {
		List<Student> students = dao.findAllWithCourses();
		System.out.println(students);
		assertNotNull(students);
		for (Student s : students) {
			System.out.println(s.getId() +":"+s.getName());
			for(StudentCourse sc : s.getCourses()){
				System.out.println(sc.getCourse().getId() +":"+ sc.getCourse().getName());
			}
		}
	}

	private void persistsData() {
		s1 = new Student();
		s2 = new Student();
		s3 = new Student();
		s1.setName("Steven");
		s2.setName("Andrew");
		s3.setName("Kekun");
		c1 = new Course();
		c2 = new Course();
		c1.setName("C programming for real-time system");
		c2.setName("JPA in action");
		s1c1 = new StudentCourse(s1, c1);
		s1c2 = new StudentCourse(s1, c2);
		s2c1 = new StudentCourse(s2, c1);
		s2c2 = new StudentCourse(s2, c2);
		transactionalEm.getTransaction().begin();
		transactionalEm.persist(s1);
		transactionalEm.persist(s2);
		transactionalEm.persist(s3);
		transactionalEm.persist(c1);
		transactionalEm.persist(c2);
		transactionalEm.persist(s1c1);
		transactionalEm.persist(s1c2);
		transactionalEm.persist(s2c1);
		transactionalEm.persist(s2c2);
		transactionalEm.getTransaction().commit();
	}
}
