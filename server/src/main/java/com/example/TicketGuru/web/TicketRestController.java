package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.Ticket;
import com.example.TicketGuru.domain.TicketRepository;

@RestController
public class TicketRestController {

	@Autowired
	TicketRepository ticketRepository;
	
	// Palauttaa listan kaikista myydyistä lipuista
	@GetMapping("/tickets")
	public Iterable<Ticket> getTickets() {
		return ticketRepository.findAll();
	}
	
	// Palauttaa id:llä haetun myydyn lipun
	@GetMapping("/tickets/{ticketId}")
	public Optional<Ticket> getTicket(@PathVariable("ticketId") Long ticketId) {
		return ticketRepository.findById(ticketId);
	}
	
	// Lisää uuden lipun myydyksi
	@PostMapping("/tickets")
	Ticket newTicket(@RequestBody Ticket newTicket) {
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
	
	
	
}
