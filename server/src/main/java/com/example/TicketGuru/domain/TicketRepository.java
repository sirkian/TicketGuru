package com.example.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	List<Ticket> findById(long ticketId);
}