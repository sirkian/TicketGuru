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

@Entity
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venue_id", nullable = false, updatable = false)
	private Long venueId;
	
	@Column(name = "venue_name", length=50)
	private String venueName;
	
	@Column(name = "venue_description", length=500)
	private String venueDescription;
	
	@Column(name = "address", length=250)
	private String address;
	
	@Column(name = "postal_code", length=10)
	private String postalCode;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketType")
	private List<Event> events;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "postal_code")
	private PostalCode PostalCode;
	
	public Venue() {
		super();
	}
	
	//Kuuluuko konstruktorissa olla tuo lista??
	public Venue(Long venueId, String venueName, String venueDescription, String address, String postalCode,
			List<Event> events) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueDescription = venueDescription;
		this.address = address;
		this.postalCode = postalCode;
		this.events = events; //??
	}

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueDescription() {
		return venueDescription;
	}

	public void setVenueDescription(String venueDescription) {
		this.venueDescription = venueDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", venueDescription=" + venueDescription
				+ ", address=" + address + ", postalCode=" + postalCode + "]";
	}

	
	
	
	
	

}
