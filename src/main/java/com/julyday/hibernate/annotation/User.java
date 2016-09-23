package com.julyday.hibernate.annotation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
@SuppressWarnings("serial")
public class User implements Serializable{
	private int id;
	private String name;
	private String password;
	private Date birthday;
	private Address address;
	
	public User() {
	}

	public User(String name, String password, Date birthday,Address address) {
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.address = address;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name",length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="password",length = 16)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="birthday")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Embedded
	@AttributeOverrides(value = { 
			@AttributeOverride(column = @Column(name="a_postcode"), name = "postcode"),
			@AttributeOverride(column = @Column(name="a_phone"), name = "phone"),
			@AttributeOverride(column = @Column(name="a_street"), name = "street") 
	})
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
