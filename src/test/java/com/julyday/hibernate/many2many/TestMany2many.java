package com.julyday.hibernate.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMany2many {
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
	public void testMany2many(){
		Student stu1 = new Student("julyday",18);
		Student stu2 = new Student("zhangsan",19);
		Teacher tea1 = new Teacher("lisi",48);
		Teacher tea2 = new Teacher("wangwu",49);
		
		Set<Teacher> ts = new HashSet<Teacher>();
		ts.add(tea1);
		ts.add(tea2);
		stu1.setTeachers(ts);
		stu2.setTeachers(ts);
		
		Set<Student> ss = new HashSet<Student>();
		ss.add(stu1);
		ss.add(stu2);
		tea1.setStudents(ss);
		tea2.setStudents(ss);
		
		session.save(tea1);
		session.save(tea2);
		session.save(stu1);
		session.save(stu2);
	}
	
}
