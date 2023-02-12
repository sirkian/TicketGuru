package com.example.TicketGuru;

import java.time.LocalDate;
import java.time.Month;

import com.example.TicketGuru.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketGuruApplication {
	
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	TicketTypeRepository ticketTypeRepository;
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	AppUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean
	public CommandLineRunner ticketguru(TicketRepository ticketRepository, TicketTypeRepository ticketTypeRepository, TransactionRepository transactionRepository) {
		return (args) -> {
			
			// TAPAHTUMAT
			
			Event event1 = new Event("Testitapahtuma", "Tapahtuman kuvaus", LocalDate.of(2023, Month.FEBRUARY, 20), LocalDate.of(2023, Month.FEBRUARY, 21), "Testikatu 1", 100);
			eventRepository.save(event1);
			Event event2 = new Event("Tapahtuma 2", "Kuvaus kakkostapahtumalle", LocalDate.of(2023, Month.FEBRUARY, 25), LocalDate.of(2023, Month.FEBRUARY, 26), "Testikatu 2", 200);
			eventRepository.save(event2);
			
			System.out.println("** Events: **");
			for (Event event : eventRepository.findAll()) {
				System.out.println("Event: " + event.toString());
			}
			System.out.println("");
			
			// LIPPUTYYPIT
			
			TicketType type1 = new TicketType("Opiskelija-lippu", 15.0, event1);
			ticketTypeRepository.save(type1);
			TicketType type2 = new TicketType("Eläkeläinen", 12.0, event1);
			ticketTypeRepository.save(type2);
			
			System.out.println("** TicketTypes: **");
			for (TicketType ticketType : ticketTypeRepository.findAll()) {
				System.out.println("TicketType: " + ticketType.toString());
			}
			System.out.println("");
			
			// LIPUT
			
			Ticket ticket1 = new Ticket("testcod1", type1, event1);
			ticketRepository.save(ticket1);
			Ticket ticket2 = new Ticket("testcod2", type2, event1);
			ticketRepository.save(ticket2);
			
			System.out.println("** Tickets: **");
			for (Ticket ticket : ticketRepository.findAll()) {
				System.out.println("Ticket: " + ticket.toString());
			}
			System.out.println("");
			
			// ROOLIT
			
			Role role1 = new Role("Admin");
			roleRepository.save(role1);
			Role role2 = new Role("Clerk");
			roleRepository.save(role2);
			Role role3 = new Role("Ticket_inspector"); 
			roleRepository.save(role3);
			
			System.out.println("** Roles: **");
			for (Role role : roleRepository.findAll()) {
				System.out.println("Role: " + role.toString());
			}
			System.out.println("");
			
			// KÄYTTÄJÄT
			
			AppUser user1 = new AppUser("Anneli", "Admin", "admin@tiketguru.com", "$2a$10$Xp67oEDHyODcnTzkIIp9z.SpmmpZg33mqZe/jvaSHMnpWtEQGov5e", "+358123456", "Järjestelmän pääkäyttäjä", "Osoite1", role1);
			userRepository.save(user1);
			AppUser user2 = new AppUser("Make", "Myyjä", "make@tiketguru.com", "$2a$10$Rc25Yhstdcr9Ce3WcQFKLeHT3nN1Yr.ud6M0AywXA8Q1tidWcdvqy", "+358654321", "Lipunmyyjä, hyvä jäbä", "Osoite2", role2);
			userRepository.save(user2);
			
			System.out.println("** Users: **");
			for (AppUser appUser : userRepository.findAll()) {
				System.out.println("User: " + appUser.toString());
			}
			System.out.println("");
			
			// MYYNTITAPAHTUMAT
			
			Transaction transaction1 = new Transaction(user2, LocalDate.now());
			transactionRepository.save(transaction1);
			
			System.out.println("** Transactions: **");
			for (Transaction transaction : transactionRepository.findAll()) {
				System.out.println("Transaction: " + transaction.toString());
			}
			System.out.println("");
		
	};
	}
	}


