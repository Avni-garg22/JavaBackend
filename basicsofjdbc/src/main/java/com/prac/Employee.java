package com.prac;

public class Employee {
private int id;
private String name;
private int age;
private String branch;
public Employee(int id,String name,int age,String branch) {
	this.id=id;
	this.age=age;
	this.name=name;
	this.branch=branch;
			
}
public boolean isValidAge() {
	if(age>17) {
		return true;
	}else
		return false;
}

public boolean isValidName() {
	if(name.length()<1) {
		return false;
	}
	for(int i=0;i<name.length()-1;i++) {
		if(!((name.charAt(i)>='A'&&name.charAt(i)<='Z')||(name.charAt(i)>='a'&&name.charAt(i)<='z')||name.charAt(i)==' ')) {
			return false;
		}
	}
	return true;
}
}
