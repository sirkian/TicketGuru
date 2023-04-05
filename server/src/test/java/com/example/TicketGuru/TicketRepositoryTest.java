// package com.example.TicketGuru;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.time.LocalDateTime;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.example.TicketGuru.domain.AppUser;
// import com.example.TicketGuru.domain.AppUserRepository;
// import com.example.TicketGuru.domain.Event;
// import com.example.TicketGuru.domain.EventRepository;
// import com.example.TicketGuru.domain.EventTicketType;
// import com.example.TicketGuru.domain.EventTicketTypeRepository;
// import com.example.TicketGuru.domain.PostalCode;
// import com.example.TicketGuru.domain.PostalCodeRepository;
// import com.example.TicketGuru.domain.Ticket;
// import com.example.TicketGuru.domain.TicketRepository;
// import com.example.TicketGuru.domain.TicketType;
// import com.example.TicketGuru.domain.TicketTypeRepository;
// import com.example.TicketGuru.domain.Transaction;
// import com.example.TicketGuru.domain.TransactionRepository;
// import com.example.TicketGuru.domain.Venue;
// import com.example.TicketGuru.domain.VenueRepository;

// @DataJpaTest
// public class TicketRepositoryTest {

// @Autowired
// private TicketRepository ticketRepository;

// @Autowired
// private AppUserRepository uRepo;

// @Autowired
// private TransactionRepository taRepo;

// @Autowired
// private TicketTypeRepository ttRepo;

// @Autowired
// private PostalCodeRepository pcRepo;

// @Autowired
// private VenueRepository vRepo;

// @Autowired
// private EventRepository eRepo;

// @Autowired
// private EventTicketTypeRepository ettRepo;

// @Test
// public void createTicket() {
// AppUser user = uRepo.findByEmail("admin@tiketguru.com");
// Transaction transaction = new Transaction(user, LocalDateTime.now());
// taRepo.save(transaction);
// TicketType type = new TicketType("Testitiketti");
// ttRepo.save(type);
// PostalCode postcode = new PostalCode("00420", "Kerava");
// pcRepo.save(postcode);
// Venue venue = new Venue("Testipaikka", "Testikuvaus", "Testikuja 2",
// postcode);
// vRepo.save(venue);
// Event event = new Event("Testitapahtuma", "Tapahtuman kuvaus",
// LocalDateTime.of(2023, 2, 14, 16, 00),
// LocalDateTime.of(2023, 2, 14, 18, 00), 100, LocalDateTime.of(2023, 2, 12, 18,
// 00), false, venue);
// eRepo.save(event);
// EventTicketType eventTicketType = new EventTicketType(12.50, event, type);
// ettRepo.save(eventTicketType);

// Ticket ticket = new Ticket("code1234", null, eventTicketType, transaction);
// ticketRepository.save(ticket);

// assertThat(ticket.getTicketId()).isNotNull();
// }
// }
