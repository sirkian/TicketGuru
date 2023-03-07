package com.example.TicketGuru.web;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		
		// Lisää uuden myyntitapahtuman
		// Lisää aikaleiman myyntitapahtumaan ennen tallentamista
		@PostMapping("/transactions")
		public Transaction newTransaction(@RequestBody Transaction newTransaction) {
			newTransaction.setTransactionDate(LocalDateTime.now());
			return transactionRepository.save(newTransaction);
		}
		
		// Muokkaa id:llä valittua myyntitapahtumaa
		@PutMapping("/transactions/{transactionId}")
		public Transaction editTransaction(@RequestBody Transaction editedTransaction, @PathVariable("transactionId") Long transactionId) {
			editedTransaction.setTransactionId(transactionId);
		 	return transactionRepository.save(editedTransaction);
		}
		
		//Poistaa myyntitapahtuman id:n perusteella
		@DeleteMapping("/transactions/{transactionId}")
		public Iterable<Transaction> deleteTransaction(@PathVariable("transactionId") Long transactionId) {
			transactionRepository.deleteById(transactionId);
			return transactionRepository.findAll();
		}

}
