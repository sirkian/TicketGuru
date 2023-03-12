package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventTicketType;
import com.example.TicketGuru.domain.EventTicketTypeRepository;

import jakarta.validation.Valid;

@RestController
public class EventTicketTypeRestController {
	
	// EventTicketType on välitaulu Eventin ja Ticketin välissä, yhteys myös TicketType-tauluun
	// Mahdollistaa valmiiden lipputyyppien hinnoittelun tapahtumakohtaisesti
	
	// Id:llä hakua varten tuskin kannattaa endpointtia tehdä
	// Myöskään poistolle ei kannata; tapahtuman lipputyypin jos poistaa, kaikki sillä myydyt liput poistuvat myös
	
	@Autowired
	private EventTicketTypeRepository ettRepository;
	
	// Haetaan kaikkien tapahtumien kaikki lipputyypit
	@GetMapping("/eventtickettypes")
	public Iterable<EventTicketType> getAllEventTicketTypes() {
		// 200 OK ja tyhjä taulukko jos ei ole lipputyyppejä
		return ettRepository.findAll();
	}
	
	// Haetaan kaikki yhden tapahtuman lipputyypit
	@GetMapping("/events/{eventId}/eventtickettypes")
	public Iterable<EventTicketType> getByEvent(@PathVariable("eventId") Event event) {
		return ettRepository.findByEvent(event);
	}
	
	@PostMapping("/eventtickettypes")
	public EventTicketType newEventTT(@Valid @RequestBody EventTicketType newEventTT) {
		try {
			return ettRepository.save(newEventTT);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}
	
	// Muokkaa tapahtuman lipputyyppiä (eventId, typeId ja hinta)
	@PutMapping("/eventtickettypes/{eventTypeId}")
	public EventTicketType editEventTT(@Valid @RequestBody EventTicketType editedETT, @PathVariable("eventTypeId") Long eventTypeId) {
		try {
			editedETT.setEventTypeId(eventTypeId);
			 return ettRepository.save(editedETT);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarkista viiteavaimet: " + e.getMessage());
		}		
	}
	
}
