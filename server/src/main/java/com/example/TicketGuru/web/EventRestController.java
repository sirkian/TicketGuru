package com.example.TicketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventRepository;
import com.example.TicketGuru.domain.Venue;
import com.example.TicketGuru.domain.VenueRepository;

import jakarta.validation.Valid;


@RestController
public class EventRestController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private VenueRepository venueRepository;
	
	// Palauttaa kaikki järjestelmään tallennetut tapahtumat
	@GetMapping("/events")
	public Iterable<Event> getAllEvents() {
		List<Event> events = (List<Event>) eventRepository.findAll();
		if (events.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Järjestelmässä ei ole ainuttakaan tapahtumaa");
		}
		return events;
	}
	
	// Palauttaa tapahtuman haetulla id:llä
	@GetMapping("/events/{eventId}")
	public Optional<Event> getEvent(@PathVariable("eventId") Long eventId) {
		Optional<Event> event = eventRepository.findById(eventId);
		if (event.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt tapahtumaa");
		}
		return event;
	}
	
	// Palauttaa tapahtumat joiden nimi sisältää hakusanan
	@GetMapping("/events/q")
	public Iterable<Event> getEventsByName(@RequestParam(value = "name") String name) {
		List<Event> events = (List<Event>) eventRepository.findByEventNameContainingIgnoreCase(name);
		if (events.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hakusanalla ei löytynyt tapahtumia");
		}
		return events;
	}
	
	// Palauttaa haetun tapahtumapaikan kaikki tapahtumat
	// Korvataan endpoint suoralla vastauksella (linkit poies)
	@GetMapping("/venues/{venueId}/events")
	public Iterable<Event> getEventsByVenue(@PathVariable("venueId") Venue venue) {	
		// HEITTÄÄ VIELÄ 500 /venues/99/events
		List<Event> events = (List<Event>) eventRepository.findByVenue(venue);
		if (events.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Haetulla tapahtumapaikalla ei ole tapahtumia");			
		}
		return events;		
	}
	
	//lisää uuden tapahtuman
	@PostMapping("/events")
	@ResponseStatus(HttpStatus.CREATED)
	public Event newEvent(@Valid @RequestBody Event newEvent) {
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
