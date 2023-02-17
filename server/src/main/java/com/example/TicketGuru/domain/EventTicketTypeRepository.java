package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EventTicketTypeRepository extends CrudRepository<EventTicketType, Long> {
	
	Optional<EventTicketType> findById(Long eventTypeId);

}
