package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// Palauttaa tapahtuman haetulla id:llä
	@GetMapping("/events/{eventId}")
	public Optional<Event> getEvent(@PathVariable("eventId") Long eventId) {
		return eventRepository.findById(eventId);	
	}
	
	// Palauttaa tapahtumat joiden nimi sisältää hakusanan
	@GetMapping("/events/search")
	public Iterable<Event> getEventByName(@RequestParam(value = "name") String name) {
		return eventRepository.findByEventNameContainingIgnoreCase(name);
	}
	
	// Muokkaa id:llä valittua tapahtumaa
	@PutMapping("/events/{eventId}")
	public Event editEvent(@RequestBody Event editedEvent, @PathVariable("eventId") Long eventId) {
		editedEvent.setEventId(eventId);
	 	return eventRepository.save(editedEvent);
	}
	
}
