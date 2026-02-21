package com.BloggingApp;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String content;

	@ManyToOne
	private Post post;

	@ManyToOne
	private User author;


	public Comment(String content, Post post, User author) {
		this.content = content;
		this.post = post;
		this.author = author;
	}
	
	public String getContent() {
	    return content;
	}
}