package com.julyday.hibernate.many2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMany2one {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		StandardServiceRegistry  serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		System.out.println("---------------");
		
	}
	
	@After
	public void distory(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testMany2one(){
		Grade g1 = new Grade("java","java学前班");
		Student stu1 = new Student("julyday",18);
		Student stu2 = new Student("zhangsan",28);
		stu1.setGrade(g1);
		stu2.setGrade(g1);
		session.save(stu1);
		session.save(stu2);
		session.save(g1);
	}
	
}
