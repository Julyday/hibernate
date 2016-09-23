package com.julyday.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestOne2many {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		StandardServiceRegistry  serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void distory(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testOne2many(){
		Grade g1 = new Grade("java","java学前班");
		Student stu1 = new Student("julyday",18);
		Student stu2 = new Student("lisi",38);
		g1.getStudents().add(stu1);
		g1.getStudents().add(stu2);
		session.save(g1);
		session.save(stu1);
		session.save(stu2);
	}
	
	@Test
	public void delete(){
//		Student stu1 = session.get(Student.class, 2);
//		session.delete(stu1);
		Grade g = session.get(Grade.class, 1);
		session.delete(g);
	}
	
}
