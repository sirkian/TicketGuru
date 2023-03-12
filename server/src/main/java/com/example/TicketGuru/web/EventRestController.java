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
	// 200 OK ja tyhjä taulukko jos ei ole tapahtumia
	public Iterable<Event> getAllEvents() {
		return eventRepository.findAll();
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
	public Iterable<Event> getEventsByVenue(@PathVariable("venueId") Long venueId) {	
		Optional<Venue> venue = venueRepository.findById(venueId);
		if (venue.isEmpty()) {
			// Heitetään 404, mikäli annetulla idllä ei ole tapahtumapaikkaa (esim. /venues/99/events)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumapaikkaa ei ole olemassa");
		}
		return eventRepository.findByVenue(venue);	
			
	}
	
	//lisää uuden tapahtuman
	@PostMapping("/events")
	@ResponseStatus(HttpStatus.CREATED)
	public Event newEvent(@Valid @RequestBody Event newEvent) {
		try {
			return eventRepository.save(newEvent);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	// Muokkaa id:llä valittua tapahtumaa
	@PutMapping("/events/{eventId}")
	public Event editEvent(@Valid @RequestBody Event editedEvent, @PathVariable("eventId") Long eventId) {
		// Haetaan tapahtuma id:llä, jotta nähdään onko olemassa
		Optional<Event> event = eventRepository.findById(eventId);
		// Jos tapahtuma on olemassa, tallennetaan muutokset
		if (event.isPresent()) {
			try {
				editedEvent.setEventId(eventId);
			 	return eventRepository.save(editedEvent);
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarkista viiteavaimet: " + e.getMessage());
			}		
		} else {
			// Jos tapahtumaa ei ole olemassa, heitetään 404
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei ole olemassa tapahtumaa");		
		}
		
	}
	
	//Poistaa tapahtuman id:n perusteella
	@DeleteMapping("/events/{eventId}")
	public Iterable<Event> deleteEvent(@PathVariable("eventId") Long eventId) {
		try {
			eventRepository.deleteById(eventId);
		} catch (Exception e) {
			// Heitetään 404 jos poisto epäonnistui, tuskin muita syitä kun olematon id 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei ole olemassa tapahtumaa");		
		}
		List<Event> events = (List<Event>) eventRepository.findAll();
		if (events.isEmpty()) {
			// Jos poistettiin viimeinen tapahtuma, palautetaan 204 
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		return events;
	}
	
	
}
