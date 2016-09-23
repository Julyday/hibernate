package com.julyday.hibernate;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Account implements Serializable {
	private int id;
	private String name;

	public Account(String name) {
		this.name = name;
	}

	public Account() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
