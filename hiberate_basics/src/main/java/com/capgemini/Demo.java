package com.capgemini;

import javax.persistence.Persistence;

public class Demo {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("postgres");
	}

}
