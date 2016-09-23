package com.julyday.hibernate.annotation;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String postcode;
	private String phone;
	private String street;
	public Address(String postcode, String phone, String street) {
		super();
		this.postcode = postcode;
		this.phone = phone;
		this.street = street;
	}
	public Address() {
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
