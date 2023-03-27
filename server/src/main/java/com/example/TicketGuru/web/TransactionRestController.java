package com.example.TicketGuru.web;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TicketGuru.domain.Transaction;
import com.example.TicketGuru.domain.TransactionRepository;

import jakarta.validation.Valid;

@RestController
public class TransactionRestController {

	@Autowired
	private TransactionRepository transactionRepository;

	// Palauttaa kaikki myyntitapahtumat
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/transactions")
	public Iterable<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	// Palauttaa id:llä haetun myyntitapahtuman
	@PreAuthorize("hasAnyAuthority('CLERK', 'ADMIN')")
	@GetMapping("/transactions/{transactionId}")
	public Optional<Transaction> getTransaction(@PathVariable("transactionId") Long transactionId) {
		Optional<Transaction> transaction = transactionRepository.findById(transactionId);
		if (transaction.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa ei löydy");
		}
		return transaction;
	}

	// Lisää uuden myyntitapahtuman
	// Lisää aikaleiman myyntitapahtumaan ennen tallentamista
	@PreAuthorize("hasAnyAuthority('CLERK', 'ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/transactions")
	public Transaction newTransaction(@Valid @RequestBody Transaction newTransaction) {
		try {
			newTransaction.setTransactionDate(LocalDateTime.now());
			return transactionRepository.save(newTransaction);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	// Muokkaa id:llä valittua myyntitapahtumaa
	@PreAuthorize("hasAnyAuthority('CLERK', 'ADMIN')")
	@PutMapping("/transactions/{transactionId}")
	public Transaction editTransaction(@Valid @RequestBody Transaction editedTransaction,
			@PathVariable("transactionId") Long transactionId) {
		// Haetaan myyntitapahtuma id:llä, jotta nähdään onko olemassa
		Optional<Transaction> transaction = transactionRepository.findById(transactionId);
		// Jos myyntitapahtuma on olemassa, haetaan id ja transactiondate m.tapahtuman
		// tiedoista ja tallennetaan muutokset
		if (transaction.isPresent()) {
			try {
				editedTransaction.setTransactionId(transactionId);
				editedTransaction.setTransactionDate(transaction.get().getTransactionDate());
				return transactionRepository.save(editedTransaction);
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}
		} else {
			// Jos myyntitapahtumaa ei ole olemassa, heitetään 404
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa ei löydy");
		}

	}

	// Poistaa myyntitapahtuman id:n perusteella
	@PreAuthorize("hasAnyAuthority('CLERK', 'ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/transactions/{transactionId}")
	public void deleteTransaction(@PathVariable("transactionId") Long transactionId) {
		try {
			// Poistetaan myyntitapahtuma, ei palauteta mitään (paitsi vastauskoodi 204)
			transactionRepository.deleteById(transactionId);
		} catch (Exception e) {
			// Heitetään 404 jos poisto epäonnistui, tuskin muita syitä kun olematon id
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei ole myyntitapahtumaa");
		}
	}

}
