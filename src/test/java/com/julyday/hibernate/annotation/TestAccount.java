package com.julyday.hibernate.annotation;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAccount {
	
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
	public void testAccount(){
		Account a = new Account("julyday");
		session.save(a);
	}
	
	@Test
	public void testUser(){
		Address address = new Address("100001","12345678987","beijing");
		User u = new User("julyday","123456",new Date(),address);
		session.save(u);
	}
}
