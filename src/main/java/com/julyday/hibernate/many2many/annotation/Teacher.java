package com.julyday.hibernate.many2many.annotation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_teacher")
@SuppressWarnings("serial")
public class Teacher implements Serializable{
	private int tid;
	private String name;
	private int age;
	private Set<Student> students = new HashSet<Student>();

	@ManyToMany(mappedBy="teachers")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Column(name="name",length=20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="age",length=3)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
