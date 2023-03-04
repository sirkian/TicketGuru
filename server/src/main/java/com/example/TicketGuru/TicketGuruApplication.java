package com.example.TicketGuru;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventRepository;
import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;
import com.example.TicketGuru.domain.RoleRepository;
import com.example.TicketGuru.domain.TicketRepository;
import com.example.TicketGuru.domain.TicketType;
import com.example.TicketGuru.domain.TicketTypeRepository;
import com.example.TicketGuru.domain.TransactionRepository;
import com.example.TicketGuru.domain.Venue;
import com.example.TicketGuru.domain.VenueRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TicketGuruAPI", version = "0.1", description = "TicketGurun Rest API"))
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
	@Autowired
	PostalCodeRepository postRepository;
	@Autowired
	VenueRepository venueRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean
	public CommandLineRunner ticketguru(TicketRepository ticketRepository, TicketTypeRepository ticketTypeRepository, TransactionRepository transactionRepository) {
		return (args) -> {
			
			// POSTINUMEROT
			
			PostalCode postcode1 = new PostalCode("00100", "Helsinki");
			postRepository.save(postcode1);
			PostalCode postcode2 = new PostalCode("33101", "Tampere 10");
			postRepository.save(postcode2);
			
			/* TO STRING AIHEUTTAA ONGELMIA TÄSSÄ
			System.out.println("** PostalCodes: **");
			for (PostalCode postalCode : postRepository.findAll()) {
				System.out.println("PostalCode: " + postalCode.toString());
			}
			System.out.println("");
			*/
			// TAPAHTUMAPAIKAT
			
			Venue venue1 = new Venue("tapahtumapaikka1", "pieni paikka", "Maitokatu 1", postcode1);
			venueRepository.save(venue1);
			Venue venue2 = new Venue("tapahtumapaikka2", "iso paikka", "Piimätie 34", postcode2);
			venueRepository.save(venue2);
			
			// TAPAHTUMAT

			Event event1 = new Event("Testitapahtuma", "Tapahtuman kuvaus", LocalDateTime.of(2023, 2, 14, 16, 00), LocalDateTime.of(2023, 2, 14, 18, 00), 100, LocalDateTime.of(2023, 2, 12, 18, 00), false, venue1);
			eventRepository.save(event1);
			Event event2 = new Event("Tapahtuma 2", "Kuvaus kakkostapahtumalle", LocalDateTime.of(2023, 4, 20, 20, 30), LocalDateTime.of(2023, 4, 20, 22, 00), 200, LocalDateTime.of(2023, 4, 19, 18, 00), false, venue2);
			eventRepository.save(event2);
			Event event3 = new Event("Kolmas tapahtuma toden sanoo", "Syvällistä pohdintaa ja runonlausuntaa aiheesta testidatan keksimisen vaikeus", LocalDateTime.of(2023, 4, 20, 20, 30), LocalDateTime.of(2023, 4, 20, 22, 00), 200, LocalDateTime.of(2023, 4, 19, 18, 00), false, venue1);
			eventRepository.save(event3);
			
			System.out.println("** Events: **");
			for (Event event : eventRepository.findAll()) {
				System.out.println("Event: " + event.toString());
			}
			System.out.println("");
			
			// LIPPUTYYPIT
			
			TicketType type1 = new TicketType("Opiskelija-lippu");
			ticketTypeRepository.save(type1);
			TicketType type2 = new TicketType("Eläkeläinen");
			ticketTypeRepository.save(type2);
			

			/* 
			System.out.println("** TicketTypes: **");
			for (TicketType ticketType : ticketTypeRepository.findAll()) {
				System.out.println("TicketType: " + ticketType.toString());
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
			
			AppUser user1 = new AppUser("Anneli", "Admin", "admin@tiketguru.com", "$2a$10$Xp67oEDHyODcnTzkIIp9z.SpmmpZg33mqZe/jvaSHMnpWtEQGov5e", "+358123456", "Järjestelmän pääkäyttäjä", "Osoite1", role1, postcode1);
			userRepository.save(user1);
			AppUser user2 = new AppUser("Make", "Myyjä", "make@tiketguru.com", "$2a$10$Rc25Yhstdcr9Ce3WcQFKLeHT3nN1Yr.ud6M0AywXA8Q1tidWcdvqy", "+358654321", "Lipunmyyjä, hyvä jäbä", "Osoite2", role2, postcode2);
			userRepository.save(user2);
			
			System.out.println("** Users: **");
			for (AppUser appUser : userRepository.findAll()) {
				System.out.println("User: " + appUser.toString());
			}
			System.out.println("");
			
			// MYYNTITAPAHTUMAT
			
			Transaction transaction1 = new Transaction(user2, LocalDateTime.now());
			transactionRepository.save(transaction1);
			Transaction transaction2 = new Transaction(user2, LocalDateTime.now());
			transactionRepository.save(transaction2);
			
			// LIPUT
			
			Ticket ticket1 = new Ticket("testcod1", type1, transaction1);
			ticketRepository.save(ticket1);
			Ticket ticket2 = new Ticket("testcod2", type2, transaction1);
			ticketRepository.save(ticket2);
			Ticket ticket3 = new Ticket("testcod3", type1, transaction2);
			ticketRepository.save(ticket3);
			
			// Lisätään luodut liput myyntitapahtumiin
			
			List<Ticket> tickets = new ArrayList<>();
			tickets.add(ticket1);
			tickets.add(ticket2);
			transaction1.setTickets(tickets);
			
			List<Ticket> tickets2 = new ArrayList<>();
			tickets2.add(ticket3);
			transaction2.setTickets(tickets2);
			
			// Lisätään myyntitapahtumat myyjälle
			
			List<Transaction> transactions = new ArrayList<>();
			transactions.add(transaction1);
			transactions.add(transaction2);
			user2.setTransactions(transactions);
			
			// Tulostellaan nyt vielä vähän lisää
			
			System.out.println("** Tickets: **");
			for (Ticket ticket : ticketRepository.findAll()) {
				System.out.println("Ticket: " + ticket.toString());
				System.out.println("Price: " + ticket.getTicketType().getPrice());
				System.out.println("Verification code: " + ticket.getVerificationCode());
				System.out.println("Event: " + ticket.getTicketType().getEvent().getEventName());
				System.out.println("Transaction: " + ticket.getTransaction().getTransactionId());
				System.out.println("");
			}
			System.out.println("");
			
			// Rautalankamallin mukainen tulostus (Kaavio 2)
			
			System.out.println("** Transactions: ** \n");
			for (Transaction transaction : transactionRepository.findAll()) {
				System.out.println("Myyntitapahtuma: " + transaction.getTransactionId());
				System.out.println("Maksettu: " + transaction.getTransactionDate()); // Huono formaatti, mutta ajaa asiansa tässä
				System.out.println("");
				// Summa pitää laskee viel, mutta siinä tuskin törmätään ongelmiin
				for (Ticket ticket : ticketRepository.findByTransaction(transaction)) {
					System.out.println("Tapahtuma: " + ticket.getTicketType().getEvent().getEventName());
					System.out.println("Lippu: " + ticket.getTicketType().getTypeName());
					System.out.println("Hinta: " + ticket.getTicketType().getPrice());
					System.out.println("Koodi: " + ticket.getVerificationCode());
					System.out.println("");
				}
				System.out.println("\n ** end of transaction ** \n");
				
			}	*/
		};
		
	}
}


