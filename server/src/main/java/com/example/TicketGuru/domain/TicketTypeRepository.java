package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {
	
	Optional<TicketType> findById(Long typeId);
}