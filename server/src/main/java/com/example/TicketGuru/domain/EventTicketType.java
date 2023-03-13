package com.example.TicketGuru.domain;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class EventTicketType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_type_id", nullable = false)
	private Long eventTypeId;
	
	@NotNull
	private double price;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private Event event;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	private TicketType ticketType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "eventTicketType")
	private List<Ticket> tickets;

	public EventTicketType() {
		super();
	}

	public EventTicketType(double price, Event event, TicketType ticketType) {
		super();
		this.price = price;
		this.event = event;
		this.ticketType = ticketType;
	}

	public Long getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "EventTicketType [eventTypeId=" + eventTypeId + ", price=" + price + "]";
	}

}
