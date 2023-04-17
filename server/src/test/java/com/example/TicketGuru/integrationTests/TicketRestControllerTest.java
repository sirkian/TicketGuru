// package com.example.TicketGuru.integrationTests;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// import com.example.TicketGuru.domain.EventTicketType;
// import com.example.TicketGuru.domain.EventTicketTypeRepository;
// import com.example.TicketGuru.domain.Ticket;
// import com.example.TicketGuru.domain.Transaction;
// import com.example.TicketGuru.domain.TransactionRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.Base64;

// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// @SpringBootTest
// @AutoConfigureMockMvc
// @ActiveProfiles("dev")
// public class TicketRestControllerTest {

// @Autowired
// private MockMvc mockMvc;

// @Autowired
// private EventTicketTypeRepository ettRepo;

// @Autowired
// private TransactionRepository tRepo;

// @Test
// public void testGetTicket() throws Exception {
// // Testataan ticketin GetById-endpoint
// mockMvc.perform(MockMvcRequestBuilders.get("/tickets/1")
// .header(HttpHeaders.AUTHORIZATION,
// "Basic " +
// Base64.getEncoder().encodeToString("admin@tiketguru.com:admin".getBytes()))
// .accept(MediaType.APPLICATION_JSON))
// .andExpect(status().isOk())
// .andExpect(jsonPath("$.ticketId").value(1));
// }

// @Test
// public void testPostTicket() throws Exception {
// // Testataan ticketin POST-endpoint
// Transaction transaction = tRepo.findById(1L).orElse(null);
// EventTicketType eventTicketType = ettRepo.findById(1L).orElse(null);
// Ticket ticket = new Ticket("resttest", null, eventTicketType, transaction);

// ObjectMapper mapper = new ObjectMapper().registerModule(new
// JavaTimeModule());
// String json = mapper.writeValueAsString(ticket);

// // Varmistetaan, että myyjän tunnuksilla luonti ok
// mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
// .contentType(MediaType.APPLICATION_JSON)
// .header(HttpHeaders.AUTHORIZATION,
// "Basic " +
// Base64.getEncoder().encodeToString("make@tiketguru.com:user".getBytes()))
// .content(json))
// .andExpect(status().isCreated())
// .andExpect(jsonPath("$.ticketId").value(4))
// .andExpect(jsonPath("$.eventTicketType.price").value(12.50))
// .andExpect(jsonPath("$.transaction.transactionId").value(1));

// // Lipuntarkastajalla ei oikeuksia, pitäisi olla forbidden
// mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
// .contentType(MediaType.APPLICATION_JSON)
// .header(HttpHeaders.AUTHORIZATION,
// "Basic " +
// Base64.getEncoder().encodeToString("liisa@tiketguru.com:inspector".getBytes()))
// .content(json))
// .andExpect(status().isForbidden());

// // Ilman tunnistautumista pitäisi olla unauthorized
// mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
// .contentType(MediaType.APPLICATION_JSON)
// .content(json))
// .andExpect(status().isUnauthorized());
// }

// @Test
// public void testDeleteTicket() throws Exception {
// // Lipun poisto ilman tunnuksia
// mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/3")
// .accept(MediaType.APPLICATION_JSON))
// .andExpect(status().isUnauthorized());

// // Lipunmyyjän tunnuksilla
// mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/3")
// .header(HttpHeaders.AUTHORIZATION,
// "Basic " +
// Base64.getEncoder().encodeToString("liisa@tiketguru.com:inspector".getBytes()))
// .accept(MediaType.APPLICATION_JSON))
// .andExpect(status().isForbidden());

// // Adminin tunnuksilla
// mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/3")
// .header(HttpHeaders.AUTHORIZATION,
// "Basic " +
// Base64.getEncoder().encodeToString("admin@tiketguru.com:admin".getBytes()))
// .accept(MediaType.APPLICATION_JSON))
// .andExpect(status().isNoContent());
// }

// }
