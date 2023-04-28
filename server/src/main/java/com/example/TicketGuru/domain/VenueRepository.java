package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue, Long> {
	
	Optional<Venue> findById(Long venueId);

	// Hakee tapahtumapaikat joiden nimi sisältää hakusananan välittämättä kirjainkoosta
	Iterable<Venue> findByVenueNameContainingIgnoreCase(String venueName);
}
