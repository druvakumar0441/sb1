package com.example.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class person {

	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	private int page;
	private String paddress;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	@Override
	public String toString() {
		return "person [pid=" + pid + ", pname=" + pname + ", page=" + page + ", paddress=" + paddress + "]";
	}
	public person( String pname, int page, String paddress) {
		super();
		this.pname = pname;
		this.page = page;
		this.paddress = paddress;
	}
	public person() {
		super();
	}
	
	
}
