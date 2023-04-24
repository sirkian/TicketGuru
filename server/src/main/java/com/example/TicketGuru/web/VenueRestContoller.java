package com.example.TicketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;
import com.example.TicketGuru.domain.Venue;
import com.example.TicketGuru.domain.VenueRepository;

import jakarta.validation.Valid;

@RestController
public class VenueRestContoller {

	@Autowired
	VenueRepository venueRepository;
	@Autowired
	PostalCodeRepository pcrepository;

	// Palauttaa listan tapahtumapaikoista
	@GetMapping("/venues")
	public Iterable<Venue> getVenues() {
		List<Venue> venues = (List<Venue>) venueRepository.findAll();
		return venueRepository.findAll();
	}

	// Palauttaa tapahtumapaikan id:llä
	@GetMapping("/venues/{venueId}")
	public Optional<Venue> getVenue(@PathVariable("venueId") Long venueId) {
		Optional<Venue> venue = venueRepository.findById(venueId);
		if (venue.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt tapahtumapaikkaa");
		}
		return venueRepository.findById(venueId);
	}

	// Palauttaa tapahtumapaikat joiden nimi sisältää hakusanan
	@GetMapping("/venues/q")
	public Iterable<Venue> getVenuesByName(@RequestParam(value = "name") String name) {
		List<Venue> venues = (List<Venue>) venueRepository.findByVenueNameContainingIgnoreCase(name);
		if (venues.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hakusanalla ei löytynyt tapahtumapaikkoja");
		}
		return venues;
	}

	// Lisää uuden tapahtumapaikan
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/venues")
	@ResponseStatus(HttpStatus.CREATED)
	public Venue newVenue(@Valid @RequestBody Venue newVenue) {
		Optional<PostalCode> postcode = pcrepository.findByPostalCode(newVenue.getPostalCode().getPostalCode());
		if (postcode.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annettua postinumeroa ei löydy");
		}
		return venueRepository.save(newVenue);
	}

	// Muokkaa tapahtumapaikkaa, jolla valittu venueId
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/venues/{venueId}")
	public Venue editVenue(@Valid @RequestBody Venue editedVenue, @PathVariable("venueId") Long venueId) {
		Optional<Venue> venue = venueRepository.findById(venueId);
		if (venue.isPresent()) {
			try {
				editedVenue.setVenueId(venueId);
				return venueRepository.save(editedVenue);
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt tapahtumapaikkaa");
		}
	}

	// Poistaa tapahtumapaikan id:n perusteella
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/venues/{venueId}")
	public Iterable<Venue> deleteVenue(@PathVariable("venueId") Long venueId) {
		Optional<Venue> venue = venueRepository.findById(venueId);
		if (venue.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt tapahtumapaikkaa");
		}
		venueRepository.deleteById(venueId);
		return venueRepository.findAll();
	}

}
