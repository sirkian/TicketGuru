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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TicketGuru.domain.Venue;
import com.example.TicketGuru.domain.VenueRepository;

import jakarta.validation.Valid;

@RestController
public class VenueRestContoller {

	@Autowired
	VenueRepository venueRepository;
	
	// palauttaa listan tapahtumapaikoista
	@GetMapping("/venues")
	public Iterable<Venue> getVenues(){
		List<Venue> venues = (List<Venue>) venueRepository.findAll();
		if (venues.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Järjestelmässä ei ole ainuttakaan tapahtumapaikkaa");
		}
		return venueRepository.findAll();
	}
	
	// Palauttaa tapahtumapaikan id:llä
	@GetMapping("/venues/{venueId}")
	public Optional<Venue> getVenue(@PathVariable("venueId") Long venueId) {
		Optional<Venue> venue = venueRepository.findById(venueId);
		if(venue.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt tapahtumapaikkaa");
		}
		return venueRepository.findById(venueId);
	}
	
	// lisää uuden tapahtumapaikan
	@PostMapping("/venues")
	@ResponseStatus(HttpStatus.CREATED)
	public Venue newVenue(@Valid @RequestBody Venue newVenue) {
		return venueRepository.save(newVenue);
	}
	
	// muokkaa tapahtumapaikkaa, jolla valittu venueId
	@PutMapping("/venues/{venueId}")
	public Venue replaceVenue(@Valid @RequestBody Venue editedVenue, @PathVariable("venueId") Long venueId) {
		Optional<Venue> venue = venueRepository.findById(venueId);
		if(venue.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt tapahtumapaikkaa");
		}
		editedVenue.setVenueId(venueId);
		return venueRepository.save(editedVenue);
	}
	//Poistaa tapahtumapaikan id:n perusteella
	@DeleteMapping("/venues/{venueId}")
	public Iterable<Venue> deleteVenue(@PathVariable("venueId") Long venueId) {
		Optional<Venue> venue = venueRepository.findById(venueId);
		if(venue.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt tapahtumapaikkaa");
		}
		venueRepository.deleteById(venueId);
		return venueRepository.findAll();
		}
		
}
