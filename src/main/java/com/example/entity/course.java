package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="course")
public class course {

	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="person_course",
			joinColumns = @JoinColumn(name="cid"),
			inverseJoinColumns = @JoinColumn(name="pid")
			)
	private List<person> p;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<person> getP() {
		return p;
	}
	public void setP(List<person> p) {
		this.p = p;
	}
	
}
