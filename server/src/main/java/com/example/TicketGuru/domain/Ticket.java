package com.example.TicketGuru.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id", nullable = false, updatable = false)
	private Long ticketId;
	
	@Column(name = "verification_code", length = 8, nullable = false, unique = true)
	private String verificationCode;
	
	@Column(name = "used_date")
	private LocalDate usedDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_type_id")
	private EventTicketType eventTicketType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;

	public Ticket() {
		super();
	}
	
	// Konstruktori ilman usedDatea, koska alkuun null
	public Ticket(String verificationCode, EventTicketType eventTicketType,
			Transaction transaction) {
		super();
		this.verificationCode = verificationCode;
		this.eventTicketType = eventTicketType;
		this.transaction = transaction;
	}

	public Ticket(String verificationCode, LocalDate usedDate, EventTicketType eventTicketType,
			Transaction transaction) {
		super();
		this.verificationCode = verificationCode;
		this.usedDate = usedDate;
		this.eventTicketType = eventTicketType;
		this.transaction = transaction;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public LocalDate getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(LocalDate usedDate) {
		this.usedDate = usedDate;
	}

	public EventTicketType getEventTicketType() {
		return eventTicketType;
	}

	public void setEventTicketType(EventTicketType eventTicketType) {
		this.eventTicketType = eventTicketType;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", verificationCode=" + verificationCode + ", usedDate=" + usedDate
				+ "]";
	}
	
}