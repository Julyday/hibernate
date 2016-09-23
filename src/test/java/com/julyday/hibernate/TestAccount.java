package com.julyday.hibernate;

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
		//4.3.0之后的版本
		StandardServiceRegistry  serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		//4.3.0之前版本（不包括4.3.0）
//		Configuration configuration = new Configuration().configure();
//		configuration.addClass(User.class);
//		configuration.addClass(Account.class);
//		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//4之前版本sessionFactory创建方式，4标记已过时，5又不过时了
//		Configuration configuration = new Configuration().configure();
//		sessionFactory = configuration.buildSessionFactory();
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
		Account a = new Account("zhangsan");
		a.setId(1);
		session.save(a);
	}
}
