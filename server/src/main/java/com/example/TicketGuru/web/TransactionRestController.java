package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.Ticket;
import com.example.TicketGuru.domain.Transaction;
import com.example.TicketGuru.domain.TransactionRepository;

@RestController
public class TransactionRestController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	// Palauttaa kaikki myyntitapahtumat
		@GetMapping("/transactions")
		public Iterable<Transaction> getAllEvents() {
			return transactionRepository.findAll();	
		}
		
		// Palauttaa id:llä haetun myyntitapahtuman
		@GetMapping("/transactions/{transactionId}")
		public Optional<Transaction> getTransaction(@PathVariable("transactionId") Long transactionId) {
			return transactionRepository.findById(transactionId);
		}
		
		//Poistaa myyntitapahtuman id:n perusteella
		@DeleteMapping("/transactions/{transactionId}")
		public Iterable<Transaction> deleteTransaction(@PathVariable("transactionId") Long transactionId) {
			transactionRepository.deleteById(transactionId);
			return transactionRepository.findAll();
		}

}
