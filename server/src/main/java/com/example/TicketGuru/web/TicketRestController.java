package com.example.TicketGuru.web;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.Ticket;
import com.example.TicketGuru.domain.TicketRepository;

@RestController
public class TicketRestController {

	@Autowired
	TicketRepository ticketRepository;
	
	// Palauttaa listan kaikista lipuista
	@GetMapping("/tickets")
	public Iterable<Ticket> getTickets() {
		return ticketRepository.findAll();
	}
	
	// Palauttaa id:llä haetun lipun
	@GetMapping("/tickets/{ticketId}")
	public Optional<Ticket> getTicket(@PathVariable("ticketId") Long ticketId) {
		return ticketRepository.findById(ticketId);
	}
	
	// Palauttaa lipun tarkastuskoodin perusteella
	// lipun tarkastuksessa voi olla hyödyllinen
	// esim http://localhost:8080/tickets/q?name=27cfbbca
	@GetMapping("/tickets/q")
	public Optional<Ticket> getTicketByVerificationCode(@RequestParam(value = "name") String verificationCode){
		return ticketRepository.findByVerificationCode(verificationCode);
	}
	
	// Lisää uuden lipun myydyksi
	// Lisää uuden lipun a8b20a8e7ce12e054b433a08439424dda2f44ce6
	@PostMapping("/tickets")
	public Ticket newTicket(@RequestBody Ticket newTicket) {
		String verificationCode = generateVerificationCode();
		newTicket.setVerificationCode(verificationCode);
		return ticketRepository.save(newTicket);
	}
	
	// Muokkaa id:llä valittua lippua
	@PutMapping("/tickets/{ticketId}")
	public Ticket editTicket(@RequestBody Ticket editedTicket, @PathVariable("ticketId") Long ticketId) {
		editedTicket.setTicketId(ticketId);
		return ticketRepository.save(editedTicket);
	}
	
	// Poistaa id:llä haetun lipun esim. virhemyyntitilanteessa
	@DeleteMapping("/tickets/{ticketId}")
	public Iterable<Ticket> deleteTicket(@PathVariable("ticketId") Long ticketId) {
		ticketRepository.deleteById(ticketId);
		return ticketRepository.findAll();
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
