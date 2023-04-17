package com.example.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.EventRepository;
import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;
import com.example.TicketGuru.domain.Venue;
import com.example.TicketGuru.domain.VenueRepository;

@DataJpaTest
@ActiveProfiles("dev")
public class EventRepositoryTest {

    @Autowired
    private PostalCodeRepository pcRepository;

    @Autowired
    private VenueRepository vRepository;

    @Autowired
    private EventRepository eRepository;

    @Test
    public void createEvent() {

        PostalCode postalCodetest = new PostalCode("00720", "Helsinki");
        pcRepository.save(postalCodetest);

        Venue venue = new Venue("Vantaa Areena", "Urheiluhalli", "Urheilutie 12",
                postalCodetest);
        vRepository.save(venue);

        Event event = new Event("Testitapahtuma", "Tapahtuman kuvaus",
                LocalDateTime.of(2023, 2, 14, 16, 00), LocalDateTime.of(2023, 2, 14, 18, 00),
                100, LocalDateTime.of(2023, 2, 12, 18, 00), false, venue);

        eRepository.save(event);

        assertThat(event.getEventId()).isNotNull();

    }

}
