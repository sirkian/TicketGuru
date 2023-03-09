package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

	Optional<Event> findById(Long eventId);
	
	// Hakee tapahtumat, joiden nimi sisältää hakusanan, välittämättä kirjainten koosta
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	Iterable<Event> findByEventNameContainingIgnoreCase(String eventName);
	
	// Hakee kaikki tapahtumapaikan tapahtumat
	// Sama toiminto kuin venues/id/events, mutta nätimpi formaatti responsessa
	Iterable<Event> findByVenue(Optional<Venue> optional);
}
