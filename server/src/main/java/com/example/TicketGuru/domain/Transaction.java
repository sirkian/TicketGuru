package com.example.TicketGuru.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", nullable = false, updatable = false)
	private Long transactionId;
	
	@Column(name = "transaction_date")
	private LocalDateTime transactionDate;
	
	// Käytetään listaa, koska lippuja voi olla yksi tai useampi.
	@JsonIgnore  
	@OneToMany(mappedBy = "transaction")
	private List<Ticket> tickets;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") 
	private AppUser appUser;
	
	
	public Transaction() {}

	
	public Transaction(AppUser appUser, LocalDateTime  transactionDate) {
		super();
		this.appUser = appUser;
		this.transactionDate = transactionDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	
	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	public List<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", tickets="
				+ tickets + ", appUser=" + appUser + "]";
	}


	
	

}
