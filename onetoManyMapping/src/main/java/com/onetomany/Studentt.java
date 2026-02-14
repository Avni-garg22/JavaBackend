package com.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Studentt {
	@Id
	private int student_id;
	private String name;
	private String branch;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", branch=" + branch + "]";
	}

}
