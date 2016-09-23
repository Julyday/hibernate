package com.julyday.hibernate.many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Teacher implements Serializable{
	private int tid;
	private String name;
	private int age;
	private Set<Student> students = new HashSet<Student>();

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher() {
		super();
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", age=" + age + "]";
	}
}
