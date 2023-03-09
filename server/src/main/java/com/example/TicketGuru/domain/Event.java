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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id", nullable = false, updatable = false)
	private Long eventId;
	
	@NotBlank
	@Size(max = 250)
	@Column(name = "event_name")
	private String eventName;
	
	@Size(max = 450)
	private String description;
	
	// Muutettu LocalDate LocalDateTimeksi, että saadaan kellonajat mukaan
	@NotNull
	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@NotNull
	@Column(name = "end_time")
	private LocalDateTime endTime;
	
	@Min(value = 1)
	@Column(name = "amount_tickets")
	private int amountTickets;
	
	@NotNull
	@Column(name = "presale_ends")
	private LocalDateTime presaleEnds;
	
	// Voiko oletusarvon laittaa näin suoraan?
	private boolean cancelled = false;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "venue_id")
	private Venue venue;
			
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<EventTicketType> eventTicketTypes;

	public Event() {
		super();
	}

	// konstruktori testikäyttöön, voi lisätä olion nimellä
	public Event(String eventName) {}
	
	public Event( String eventName, String description, LocalDateTime startTime, LocalDateTime endTime,
		 int amountTickets, LocalDateTime presaleEnds, boolean cancelled, Venue venue) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public List<EventTicketType> getEventTicketTypes() {
		return eventTicketTypes;
	}

	public void setEventTicketTypes(List<EventTicketType> eventTicketTypes) {
		this.eventTicketTypes = eventTicketTypes;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", description=" + description
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", amountTickets="
				+ amountTickets + ", presaleEnds=" + presaleEnds + ", cancelled=" + cancelled + "]";
	}

	
}
