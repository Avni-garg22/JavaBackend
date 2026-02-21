package com.BloggingApp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String content;

	@ManyToOne
	private User author;

	@OneToMany
	private List<Comment> comments;

	public Post() {
	}

	public Post(String title, String content, User author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public String getTitle() {
	    return title;
	}

	public int getId() {
	    return id;
	}
	
}