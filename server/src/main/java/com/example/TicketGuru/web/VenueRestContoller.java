package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.Venue;
import com.example.TicketGuru.domain.VenueRepository;

@RestController
public class VenueRestContoller {

	@Autowired
	VenueRepository venueRepository;
	
	// palauttaa listan tapahtumapaikoista
	@GetMapping("/venues")
	public Iterable<Venue> getVenues(){
		return venueRepository.findAll();
	}
	
	
	// lisää uuden tapahtumapaikan
	@PostMapping("venues")
	Venue newVenue(@RequestBody Venue newVenue) {
		return venueRepository.save(newVenue);
	}
	
}
