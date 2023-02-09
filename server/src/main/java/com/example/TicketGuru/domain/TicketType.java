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
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_type")
public class TicketType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_id", nullable = false, updatable = false)
	private Long typeId;
	
	@Column(name = "type_name", length = 25, nullable = false)
	private String typeName;
	
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private Event event;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
	private List<Ticket> tickets;

	public TicketType() {
		super();
	}

	public TicketType(Long typeId, String typeName, double price, Event event) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.price = price;
		this.event = event;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "TicketType [typeId=" + typeId + ", typeName=" + typeName + ", price=" + price + "]";
	}
	
	
	
}
