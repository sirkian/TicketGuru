package com.example.TicketGuru.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.TicketGuru.domain.Event;
import com.example.TicketGuru.domain.Venue;
import com.example.TicketGuru.domain.VenueRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDateTime;
import java.util.Base64;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class EventRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VenueRepository venueRepo;

    @Test
    public void testGetEvents() throws Exception {
        // Testataan tapahtumien haku ilman tunnistautumista
        mockMvc.perform(MockMvcRequestBuilders.get("/events")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostEvent() throws Exception {
        Venue venue = venueRepo.findById(1L).orElse(null);
        LocalDateTime sTime = LocalDateTime.of(2023, 4, 20, 21, 30, 0);
        LocalDateTime eTime = LocalDateTime.of(2023, 4, 20, 23, 00, 0);
        LocalDateTime presaleEnds = LocalDateTime.of(2023, 4, 19, 00, 00, 0);

        Event event = new Event("Integraatiotestausseminaari", "kuvaus", sTime, eTime, 250, presaleEnds, false, venue);

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String json = mapper.writeValueAsString(event);

        // Tapahtuman luonti ilman autentikointia (unauthorized)
        mockMvc.perform(MockMvcRequestBuilders.post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isUnauthorized());

        // Tapahtuman luonti myyjän tunnuksilla (forbidden)
        mockMvc.perform(MockMvcRequestBuilders.post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64.getEncoder().encodeToString("make@tiketguru.com:user".getBytes()))
                .content(json))
                .andExpect(status().isForbidden());

        // Tapahtuman luonti adminin tunnuksilla (created)
        mockMvc.perform(MockMvcRequestBuilders.post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64.getEncoder().encodeToString("admin@tiketguru.com:admin".getBytes()))
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.eventId").value(4))
                .andExpect(jsonPath("$.amountTickets").value(250))
                .andExpect(jsonPath("$.venue.venueName").value("tapahtumapaikka1"));
    }
}
