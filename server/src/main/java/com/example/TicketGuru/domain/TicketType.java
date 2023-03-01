package com.example.TicketGuru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketType")
	private List<EventTicketType> eventTicketTypes;

	public TicketType() {
		super();
	}
	
	

	public TicketType(String typeName) {
		super();
		this.typeName = typeName;
	}


	public TicketType(String typeName, List<EventTicketType> eventTicketType) {
		super();
		this.typeName = typeName;
		this.eventTicketTypes = eventTicketType;
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

	public List<EventTicketType> getEventTicketType() {
		return eventTicketTypes;
	}

	public void setEventTicketType(List<EventTicketType> eventTicketType) {
		this.eventTicketTypes = eventTicketType;
	}

	@Override
	public String toString() {
		return "TicketType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
