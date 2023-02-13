package com.example.TicketGuru.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	Optional<Ticket> findById(Long ticketId);
	List<Ticket> findByTransaction(Transaction transaction);
}