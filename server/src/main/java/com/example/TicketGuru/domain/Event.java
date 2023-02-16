package com.example.TicketGuru.domain;

import java.time.LocalDateTime;
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
	
	// Muutettu LocalDate LocalDateTimeksi, että saadaan kellonajat mukaan
	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@Column(name = "end_time")
	private LocalDateTime endTime;
	
	@Column(length = 250)
	private String address;
	
	@Column(name = "amount_tickets")
	private int amountTickets;
	
	@Column(name = "presale_ends")
	private LocalDateTime presaleEnds;
	
	private boolean cancelled = false;
	
	// Kommentoitu tämä pois, kun otetaan käyttöön Venue -taulu, jonka sisässä yhteys PostalCodeen, 
	// poistettu myös getterit ja setterit
	// yhtä postinumeroa vastaa usea event
	// @ManyToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name="postal_code")
	// private PostalCode postalCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "venue_id")
	private Venue venue;
			
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<TicketType> ticketTypes;

	public Event() {
		super();
	}

	// konstruktori testikäyttöön, voi lisätä olion nimellä
	public Event(String eventName) {}
	
	public Event( String eventName, String description, LocalDateTime startTime, LocalDateTime endTime,
			String address, int amountTickets, LocalDateTime presaleEnds, boolean cancelled, Venue venue) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
		this.amountTickets = amountTickets;
		this.presaleEnds = presaleEnds;
		this.cancelled = cancelled;
		this.venue = venue;
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

	public LocalDateTime getPresaleEnds() {
		return presaleEnds;
	}

	public void setPresaleEnds(LocalDateTime presaleEnds) {
		this.presaleEnds = presaleEnds;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public List<TicketType> getTicketTypes() {
		return ticketTypes;
	}

	public void setTicketTypes(List<TicketType> ticketTypes) {
		this.ticketTypes = ticketTypes;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", description=" + description
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", address=" + address + ", amountTickets="
				+ amountTickets + ", presaleEnds=" + presaleEnds + ", cancelled=" + cancelled + "]";
	}

	
}
