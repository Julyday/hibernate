package com.julyday.hibernate.many2one;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Grade implements Serializable {
	private int gid;
	private String gname;
	private String gdesc;
	
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

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
