package com.example.TicketGuru.web;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TicketGuru.domain.Ticket;
import com.example.TicketGuru.domain.TicketRepository;
import com.example.TicketGuru.domain.Transaction;
import com.example.TicketGuru.domain.TransactionRepository;

import jakarta.validation.Valid;

@RestController
public class TicketRestController {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired 
	private TransactionRepository transactionRepository;
	
	// Palauttaa listan kaikista lipuista
	@GetMapping("/tickets")
	public Iterable<Ticket> getTickets() {
		// 200 OK ja tyhjä taulukko jos ei ole lippuja, muuten palauttaa kaikki liput
		return ticketRepository.findAll();
	}
	
	// Palauttaa id:llä haetun lipun
	@GetMapping("/tickets/{ticketId}")
	public Optional<Ticket> getTicket(@PathVariable("ticketId") Long ticketId) {
		Optional<Ticket> ticket = ticketRepository.findById(ticketId);
		if (ticket.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lippua ei löytynyt annetulla id:llä");
		}
		return ticket;
	}
	
	// Palauttaa lipun tarkastuskoodin perusteella
	// lipun tarkastuksessa voi olla hyödyllinen
	// esim http://localhost:8080/tickets/q?name=27cfbbca
	@GetMapping("/tickets/q")
	public Optional<Ticket> getTicketByVerificationCode(@RequestParam(value = "name") String verificationCode){
		Optional<Ticket> ticket = ticketRepository.findByVerificationCode(verificationCode);
		if (ticket.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Koodia vastaavaa lippua ei löytynyt");
		}
		return ticket;
	}
	
	@GetMapping("/transactions/{transactionId}/tickets")
	public Iterable<Ticket> getTicketByTransaction(@PathVariable("transactionId") Long transactionId) {
		// Haetaan myyntitapahtuma parametrinä tulleella id:llä
		Optional<Transaction> transaction = transactionRepository.findById(transactionId);
		if (transaction.isEmpty()) {
			// Jos myyntitapahtumaa ei ole, heitetään 404
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa ei ole olemassa");
		}
		return ticketRepository.findByTransaction(transaction);
	}
	
	// Lisää uuden lipun myydyksi
	// Lisää uuden lipun a8b20a8e7ce12e054b433a08439424dda2f44ce6
	@PreAuthorize("hasAnyAuthority('CLERC', 'ADMIN')")
	@PostMapping("/tickets")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket newTicket(@Valid @RequestBody Ticket newTicket) {
		// Kutsutaan metodia jolla luodaan tarkastuskoodi
		String verificationCode = generateVerificationCode();
		try {
			newTicket.setVerificationCode(verificationCode);
			return ticketRepository.save(newTicket);
		} catch (Exception e) {
			// Heitetään 400 jos menee validoinnista läpi, muttei silti onnistu (esim eventId 999)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}	
	}
	
	// Muokkaa id:llä valittua lippua
	@PreAuthorize("hasAnyAuthority('CLERC', 'ADMIN')")
	@PutMapping("/tickets/{ticketId}")
	public Ticket editTicket(@Valid @RequestBody Ticket editedTicket, @PathVariable("ticketId") Long ticketId) {
		// Haetaan lippu id:llä, jotta nähdään onko olemassa
		Optional<Ticket> ticket = ticketRepository.findById(ticketId);
		// Jos lippu on olemassa, haetaan id ja verificationcode lipun tiedoista ja tallennetaan muutokset
		if (ticket.isPresent()) {
			try {
				editedTicket.setTicketId(ticketId);
				editedTicket.setVerificationCode(ticket.get().getVerificationCode());
				return ticketRepository.save(editedTicket);
			} catch (Exception e) {
				// Heitetään 404 jos eventIdtä ei löydy
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarkista viiteavaimet: " + e.getMessage());
			}				
		} else {
			// Jos lippua ei ole olemassa, heitetään 404
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei ole olemassa lippua");	
		}

	}
	
	// Poistaa id:llä haetun lipun esim. virhemyyntitilanteessa
	@PreAuthorize("hasAnyAuthority('CLERC', 'ADMIN')")
	@DeleteMapping("/tickets/{ticketId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTicket(@PathVariable("ticketId") Long ticketId) {
		try {
			ticketRepository.deleteById(ticketId);
		} catch (Exception e) {
			// Heitetään 404 jos poisto epäonnistui, tuskin muita syitä kun olematon id 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei ole olemassa lippua");	
		}
	}
	
	// METODIT
	
	// Luodaan jokaiselle lipulle varmistuskoodi
	private static String generateVerificationCode() {
		UUID randomUUID = UUID.randomUUID();
		// RandomUUIDin luoma merkkijono sisältää välillä alaviivoja, poistetaan ne
		String code = randomUUID.toString().replaceAll("_", "");
		// RandomUUID palauttaa 32-merkkiä pitkän merkkijonon, palautetaan 8 ekaa merkkiä
		return code.substring(0, 8);
	}
	
	
	
}
