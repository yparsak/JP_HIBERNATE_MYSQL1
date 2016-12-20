package com.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="User")
public class User {

	@Id
	@Column (name="id")
	private int id;
	
	@Column (name="name")
	private String name;
	
	@Column (name="telephone")
	private String telephone;
	
	
	public void setid(int id) {
		this.id = id;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void settelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public int getid() {
		return this.id;
	}
	
	public String getname() {
		return this.name;
	}
	
	public String gettelephone() {
		return this.telephone;
	}
}

