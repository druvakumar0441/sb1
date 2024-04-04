package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="simcard")
public class simcard {

	@Id
	@GeneratedValue
	private int sid;
	private String sname;
	private long snum;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid")
	private person p;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getSnum() {
		return snum;
	}
	public void setSnum(long snum) {
		this.snum = snum;
	}
	public person getP() {
		return p;
	}
	public void setP(person p) {
		this.p = p;
	}
}
