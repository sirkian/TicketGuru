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
	@JoinColumn(name = "type_id")
	private TicketType ticketType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private Event event;

	public Ticket() {
		super();
	}

	public Ticket(Long ticketId, String verificationCode, LocalDate usedDate, TicketType ticketType, Event event) {
		super();
		this.ticketId = ticketId;
		this.verificationCode = verificationCode;
		this.usedDate = usedDate;
		this.ticketType = ticketType;
		this.event = event;
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

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", verificationCode=" + verificationCode + ", usedDate=" + usedDate
				+ "]";
	}
	
	
	
}