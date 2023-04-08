package com.example.TicketGuru;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import com.example.TicketGuru.domain.AppUser_Role;
import com.example.TicketGuru.domain.AppUser_RoleRepository;
import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventRepository;
import com.example.TicketGuru.domain.EventTicketType;
import com.example.TicketGuru.domain.EventTicketTypeRepository;
import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;
import com.example.TicketGuru.domain.Role;
import com.example.TicketGuru.domain.RoleRepository;
import com.example.TicketGuru.domain.Ticket;
import com.example.TicketGuru.domain.TicketRepository;
import com.example.TicketGuru.domain.TicketType;
import com.example.TicketGuru.domain.TicketTypeRepository;
import com.example.TicketGuru.domain.Transaction;
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
	AppUser_RoleRepository userRoleRepository;
	@Autowired
	PostalCodeRepository postRepository;
	@Autowired
	VenueRepository venueRepository;
	@Autowired
	EventTicketTypeRepository eventTicketTypeRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean
	@Profile("dev")
	public CommandLineRunner ticketguru(TicketRepository ticketRepository, TicketTypeRepository ticketTypeRepository,
			TransactionRepository transactionRepository) {
		return (args) -> {
			
			// POSTINUMEROT

			PostalCode postcode1 = new PostalCode("00100", "Helsinki");
			postRepository.save(postcode1);
			PostalCode postcode2 = new PostalCode("33101", "Tampere");
			postRepository.save(postcode2);

			// TAPAHTUMAPAIKAT

			Venue venue1 = new Venue("tapahtumapaikka1", "pieni paikka", "Maitokatu 1",
					postcode1);
			venueRepository.save(venue1);
			Venue venue2 = new Venue("tapahtumapaikka2", "iso paikka", "Piimätie 34", postcode2);
			venueRepository.save(venue2);

			// TAPAHTUMAT

			Event event1 = new Event("Testitapahtuma", "Tapahtuman kuvaus",
					LocalDateTime.of(2023, 2, 14, 16, 00), LocalDateTime.of(2023, 2, 14, 18, 00),
					100, LocalDateTime.of(2023, 2, 12, 18, 00), false, venue1);
			eventRepository.save(event1);
			Event event2 = new Event("Tapahtuma 2",
					"Kuvaus kakkostapahtumalle", LocalDateTime.of(2023, 4, 20, 20, 30),
					LocalDateTime.of(2023, 4, 20, 22, 00), 200, LocalDateTime.of(2023, 4, 19, 18,
							00),
					false, venue2);
			eventRepository.save(event2);
			Event event3 = new Event("Kolmas tapahtuma toden sanoo",
					"Syvällistä pohdintaa ja runonlausuntaa aiheesta testidatan keksimisen vaikeus",
					LocalDateTime.of(2023, 4, 20, 20, 30), LocalDateTime.of(2023, 4, 20, 22,
							00),
					200, LocalDateTime.of(2023, 4, 19, 18, 00), false, venue1);
			eventRepository.save(event3);

			// LIPPUTYYPIT

			TicketType type1 = new TicketType("Opiskelija-lippu");
			ticketTypeRepository.save(type1);
			TicketType type2 = new TicketType("Eläkeläinen");
			ticketTypeRepository.save(type2);

			// EVENTTICKETTYPE- välitaulu

			EventTicketType eventTicketType1 = new EventTicketType(12.50, event1, type1);
			eventTicketTypeRepository.save(eventTicketType1);

			// ROOLIT

			Role role1 = new Role("Admin");
			roleRepository.save(role1);
			Role role2 = new Role("Clerk");
			roleRepository.save(role2);
			Role role3 = new Role("Ticket_inspector");
			roleRepository.save(role3);

			// KÄYTTÄJÄT

			// admin
			AppUser user1 = new AppUser("Anneli", "Admin", "admin@tiketguru.com",
					"$2a$10$Xp67oEDHyODcnTzkIIp9z.SpmmpZg33mqZe/jvaSHMnpWtEQGov5e", "+358123456",
					"Järjestelmän pääkäyttäjä", "Osoite1", postcode1);
			userRepository.save(user1);

			// user
			AppUser user2 = new AppUser("Make", "Myyjä", "make@tiketguru.com",
					"$2a$10$Rc25Yhstdcr9Ce3WcQFKLeHT3nN1Yr.ud6M0AywXA8Q1tidWcdvqy", "+358654321",
					"Lipunmyyjä, hyvä jäbä", "Osoite2", postcode2);
			userRepository.save(user2);

			// inspector
			AppUser user3 = new AppUser("Liisa", "Lipuntarkastaja", "liisa@tiketguru.com",
					"$2a$10$XZ5gr2DXwRTI5u0onj93suaESAYgnN2LNEeGmEx.ZbfK7DF7imOky", "+3581234567",
					"Lipuntarkastaja ovella", "Osoite2", postcode2);
			userRepository.save(user3);

			AppUser_Role appuserRole = new AppUser_Role(user1, role1);
			userRoleRepository.save(appuserRole);
			AppUser_Role appuserRole2 = new AppUser_Role(user2, role2);
			userRoleRepository.save(appuserRole2);
			AppUser_Role appuserRole3 = new AppUser_Role(user1, role2);
			userRoleRepository.save(appuserRole3);
			AppUser_Role appuserRole4 = new AppUser_Role(user3, role3);
			userRoleRepository.save(appuserRole4);

			// MYYNTITAPAHTUMAT

			Transaction transaction1 = new Transaction(user2, LocalDateTime.now());
			transactionRepository.save(transaction1);
			Transaction transaction2 = new Transaction(user2, LocalDateTime.now());
			transactionRepository.save(transaction2);

			// LIPUT

			Ticket ticket1 = new Ticket("testcod1", null, eventTicketType1, transaction1);
			ticketRepository.save(ticket1);
			Ticket ticket2 = new Ticket("testcod2", null, eventTicketType1, transaction1);
			ticketRepository.save(ticket2);
			Ticket ticket3 = new Ticket("testcod3", null, eventTicketType1, transaction2);
			ticketRepository.save(ticket3);
			
			// // Lisätään luodut liput myyntitapahtumiin

			// List<Ticket> tickets = new ArrayList<>(); tickets.add(ticket1);
			// tickets.add(ticket2); transaction1.setTickets(tickets);

			// List<Ticket> tickets2 = new ArrayList<>(); tickets2.add(ticket3);
			// transaction2.setTickets(tickets2);

			// // Lisätään myyntitapahtumat myyjälle

			// List<Transaction> transactions = new ArrayList<>();
			// transactions.add(transaction1); transactions.add(transaction2);
			// user2.setTransactions(transactions);

		};

	}
}
