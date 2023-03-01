package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventTicketType;
import com.example.TicketGuru.domain.EventTicketTypeRepository;

@RestController
public class EventTicketTypeRestController {
	
	@Autowired
	private EventTicketTypeRepository ettRepository;
	
	@GetMapping("/eventtickettypes")
	public Iterable<EventTicketType> getAllEventTicketTypes() {
		return ettRepository.findAll();
	}
	
	// Haetaan kaikki yhden tapahtuman lipputyypit
	@GetMapping("/events/{eventId}/eventtickettypes")
	public Iterable<EventTicketType> getByEvent(@PathVariable("eventId") Event event) {
		return ettRepository.findByEvent(event);
	}
	
	@PostMapping("/eventtickettypes")
	public EventTicketType newEventTT(@RequestBody EventTicketType newEventTT) {
		return ettRepository.save(newEventTT);
	}
}
