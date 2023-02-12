package com.example.TicketGuru.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", nullable = false, updatable = false)
	private Long transactionId;
	
	@Column(name = "transaction_date", nullable = false)
	private LocalDate transactionDate;
	
	// Käytetään listaa, koska lippuja voi olla yksi tai useampi.
	@JsonIgnore  
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "transaction")
	private List<Ticket> tickets;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") 
	private AppUser appUser;
	
	
	public Transaction() {}

	
	public Transaction(AppUser appUser, LocalDate transactionDate) {
		super();
		this.transactionDate = transactionDate;
		this.appUser = appUser;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
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
