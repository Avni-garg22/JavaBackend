package com.Fintect;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	private String fullName;
	private String email;
	private String phone;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private BankAccount bankAccount;

	@ManyToMany
	@JoinTable(name = "customer_card", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
	private List<Card> cards = new ArrayList<>();

	public Customer() {
	}

	public Customer(String fullName, String email, String phone) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<Card> getCards() {
		return cards;
	}
}
