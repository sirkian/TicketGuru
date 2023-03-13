package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {

	Optional<TicketType> findById(Long typeId);

	// hakee lipputyypit kannasta tyypin nimellä, kirjainten koolla ei väliä
	Iterable<TicketType> findByTypeNameContainingIgnoreCase(String typeName);

}