package com.example.TicketGuru.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	Optional<Ticket> findById(Long ticketId);
	
	// myyntitapahtuman liput
	Iterable<Ticket> findByTransaction(Optional<Transaction> transaction);
	
	// lipun haku varmennuskoodilla
	Optional<Ticket> findByVerificationCode(String verificationCode);
	
}