package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventRepository;
import com.example.TicketGuru.domain.Venue;


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
	@GetMapping("/events/q")
	public Iterable<Event> getEventsByName(@RequestParam(value = "name") String name) {
		return eventRepository.findByEventNameContainingIgnoreCase(name);
	}
	
	// Palauttaa haetun tapahtumapaikan kaikki tapahtumat
	// Korvataan endpoint suoralla vastauksella (linkit poies)
	@GetMapping("/venues/{venueId}/events")
	public Iterable<Event> getEventsByVenue(@PathVariable("venueId") Venue venue) {
		return eventRepository.findByVenue(venue);
	}
	
	//lisää uuden tapahtuman
	@PostMapping("/events")
	Event newEvent(@RequestBody Event newEvent) {
		return eventRepository.save(newEvent);
	}
	
	// Muokkaa id:llä valittua tapahtumaa
	@PutMapping("/events/{eventId}")
	public Event editEvent(@RequestBody Event editedEvent, @PathVariable("eventId") Long eventId) {
		editedEvent.setEventId(eventId);
	 	return eventRepository.save(editedEvent);
	}
	
	//Poistaa tapahtuman id:n perusteella
	@DeleteMapping("/events/{eventId}")
	public Iterable<Event> deleteEvent(@PathVariable("eventId") Long eventId) {
		eventRepository.deleteById(eventId);
		return eventRepository.findAll();
	}
	
	
}
