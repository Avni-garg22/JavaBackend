package com.BloggingApp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String password;
	private String email;

	@OneToMany
	private List<Post> posts;

	@OneToMany
	private List<Comment> comments;

	public User() {
	}

	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}
}
