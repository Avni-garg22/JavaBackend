package com.onetomany;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Collegee {
	@Id
	private int id;
	private String name;
	private String location;
	private String pincode;
	@OneToMany
	private List<Studentt> student;
	
	public List<Studentt> getS() {
		return student;
	}
	public void setS(List<Studentt> s) {
		this.student = s;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", location=" + location + ", pincode=" + pincode + "]";
	}

}