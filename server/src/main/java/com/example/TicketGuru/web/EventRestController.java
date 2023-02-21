package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventRepository;

@RestController
public class EventRestController {
	
	@Autowired
	private EventRepository eventRepository;
	
	// Palauttaa kaikki järjestelmään tallennetut tapahtumat
	@GetMapping("/events")
	public Iterable<Event> getAllEvents() {
		return eventRepository.findAll();	
	}
	
	// Muokkaa valittua tapahtumaa
	@PutMapping("/events/{eventId}")
	Event editEvent(@RequestBody Event editedEvent, @PathVariable Long eventId) {
		editedEvent.setEventId(eventId);
		return eventRepository.save(editedEvent);
	}
	
}
