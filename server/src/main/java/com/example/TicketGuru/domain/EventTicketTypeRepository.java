package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EventTicketTypeRepository extends CrudRepository<EventTicketType, Long> {

	Optional<EventTicketType> findById(Long eventTypeId);

	// Haetaan kaikki tapahtuman lipputyypit
	Iterable<EventTicketType> findByEvent(Optional<Event> event);

	EventTicketType getById(Long eventTypeId);



}
