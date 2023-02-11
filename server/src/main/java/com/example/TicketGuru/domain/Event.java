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
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id", nullable = false)
	private Long eventId;
	
	@Column(name = "event_name", length=100)
	private String eventName;
	
	@Column(length = 450)
	private String description;
	
	@Column(name = "start_time")
	private LocalDate startTime;
	
	@Column(name = "end_time")
	private LocalDate endTime;
	
	@Column(length = 250)
	private String address;
	
	@Column(name = "amount_tickets")
	private int amountTickets;
	
	// postalcode- luokkaa ei ole vielä, yhteys one-to-many -> eventissä yksi postinro
	// yhtä postinumeroa vastaa usea event
	//ManyToOne
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="postal_code")
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@JsonIgnore // to prevent infinite loop in rest service
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
	private List<Ticket> tickets;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketType")
	private List<TicketType> ticket_types;


	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Event() {
		super();
	}

	// konstruktori testikäyttöön, voi lisätä olion nimellä
	
	public Event(String eventName) {
		super();
		this.eventName = eventName;
	}
	

	public Event(String eventName, String description, LocalDate startTime, LocalDate endTime, String address,
			int amountTickets, String postalCode, List<Ticket> tickets, List<TicketType> ticket_types) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
		this.amountTickets = amountTickets;
		this.postalCode = postalCode;
		this.tickets = tickets;
		this.ticket_types = ticket_types;
	}

	public List<TicketType> getTicket_types() {
		return ticket_types;
	}

	public void setTicket_types(List<TicketType> ticket_types) {
		this.ticket_types = ticket_types;
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


	public LocalDate getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}


	public LocalDate getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDate endTime) {
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


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", description=" + description
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", address=" + address + ", amountTickets="
				+ amountTickets + ", postalCode=" + postalCode + ", tickets=" + tickets + ", ticket_types="
				+ ticket_types + "]";
	}

	
}
