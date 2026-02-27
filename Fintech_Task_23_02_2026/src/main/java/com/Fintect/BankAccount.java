package com.Fintect;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;

	private String accountNumber;
	private String accountType;
	private BigDecimal balance;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactions = new ArrayList<>();

	public BankAccount() {
	}

	public BankAccount(String accountNumber, String accountType, BigDecimal balance) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}

	public Long getAccountId() {
		return accountId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void addTransaction(Transaction txn) {
		transactions.add(txn);
		txn.setBankAccount(this);
	}
}
