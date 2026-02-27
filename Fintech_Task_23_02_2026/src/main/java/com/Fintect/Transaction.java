package com.Fintect;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	private String txnType;
	private BigDecimal amount;
	private LocalDateTime txnDate;
	private String description;
	private String referenceNumber;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private BankAccount bankAccount;

	public Transaction() {
	}

	public Transaction(String txnType, BigDecimal amount, String description, String referenceNumber) {
		this.txnType = txnType;
		this.amount = amount;
		this.description = description;
		this.referenceNumber = referenceNumber;
		this.txnDate = LocalDateTime.now();
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
}
