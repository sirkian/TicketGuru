package com.example.TicketGuru.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id", nullable = false)
	private Long eventId;
	
	@Column(name = "event_name", length=100)
	private String eventName;
	
	@Column(length = 450)
	private String description;
	
	// Muutettu LocalDate LocalDateTimeksi, että saadaan kellonajat mukaan
	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@Column(name = "end_time")
	private LocalDateTime endTime;
	
	@Column(length = 250)
	private String address;
	
	@Column(name = "amount_tickets")
	private int amountTickets;
	
	// yhtä postinumeroa vastaa usea event
	// ManyToOne
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="postal_code")
	private PostalCode postalCode;
	
	/*
	@JsonIgnore // to prevent infinite loop in rest service
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
	private List<Ticket> tickets;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<TicketType> ticketTypes;
	*/

	public Event() {
		super();
	}

	// konstruktori testikäyttöön, voi lisätä olion nimellä
	
	public Event(String eventName) {}
	

	public Event(String eventName, String description, LocalDateTime startTime, LocalDateTime endTime, String address,
			int amountTickets, PostalCode postalCode) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
		this.amountTickets = amountTickets;
		this.postalCode = postalCode;
	}


	public Long getEventId() {
		return eventId;
	}


	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAmountTickets() {
		return amountTickets;
	}


	public void setAmountTickets(int amountTickets) {
		this.amountTickets = amountTickets;
	}


	public PostalCode getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}


	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", description=" + description
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", address=" + address + ", amountTickets="
				+ amountTickets + ", postalCode=" +  postalCode
				+"]";
	}

	
}
