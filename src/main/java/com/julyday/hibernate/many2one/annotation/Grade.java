package com.julyday.hibernate.many2one.annotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_grade")
@SuppressWarnings("serial")
public class Grade implements Serializable {
	private int gid;
	private String gname;
	private String gdesc;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	@Column(name="gname",length=20)
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	@Column(name="gdesc",length=20)
	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Grade() {
		super();
	}

	public Grade(String gname, String gdesc) {
		super();
		this.gname = gname;
		this.gdesc = gdesc;
	}

	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + ", gdesc=" + gdesc
				+ "]";
	}

}
