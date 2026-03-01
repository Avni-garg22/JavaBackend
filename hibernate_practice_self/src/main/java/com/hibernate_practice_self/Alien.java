package com.hibernate_practice_self;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alien_table")
public class Alien {
	@Id
	private int aid;
//	private String aname;
	private Alienname aname;
	private String color;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

//	public String getAname() {
//		return aname;
//	}
//
//	public void setAname(String aname) {
//		this.aname = aname;
//	}

	public String getColor() {
		return color;
	}

	public Alienname getAname() {
		return aname;
	}

	public void setAname(Alienname aname) {
		this.aname = aname;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}

//	@Override
//	public String toString() {
//		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
//	}
	
	

}
