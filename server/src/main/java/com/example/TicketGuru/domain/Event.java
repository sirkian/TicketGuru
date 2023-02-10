package com.example.TicketGuru.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eventId;
	
	@Column(name = "event_name")
	private String eventName;
	
	private String description;
	
	@Column(name = "start_time")
	private LocalDate startTime;
	
	@Column(name = "end_time")
	private LocalDate endTime;
	
	private String address;
	
	@Column(name = "amount_tickets")
	private int amountTickets;
	
	// postalcode- luokkaa ei ole vielä, yhteys one-to-many -> eventissä yksi postinro
	// yhtä postinumeroa vastaa usea postal code
	//ManyToOne
	//@ManyToOne
	//@JoinColumn(name="postal_code")
	
	@Column(name = "postal_code")
	private String postalCode;


	public Event() {
		super();
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
				+ amountTickets + ", postalCode=" + postalCode + "]";
	}
	
	

}
