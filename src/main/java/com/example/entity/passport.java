package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="passport")
public class passport {

	@Id
	@GeneratedValue
	private int ppid;
	private String ppnum;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid")
	private person p;
	public int getPid() {
		return ppid;
	}
	public void setPid(int pid) {
		this.ppid = pid;
	}
	public String getPnum() {
		return ppnum;
	}
	public void setPnum(String pnum) {
		this.ppnum = pnum;
	}
	public person getP() {
		return p;
	}
	public void setP(person p) {
		this.p = p;
	}
	
}
