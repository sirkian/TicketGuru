package com.example.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.TicketGuru.domain.TicketType;
import com.example.TicketGuru.domain.TicketTypeRepository;

@DataJpaTest
public class TicketTypeRepositoryTest {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Test
    public void createAndEditTicketType() {
        TicketType ticketType = new TicketType("Testilippu");
        ticketTypeRepository.save(ticketType);
        assertThat(ticketType.getTypeId()).isNotNull();
        ticketType.setTypeName("Muokattu lippu");
        assertThat(ticketType.getTypeName()).isEqualTo("Muokattu lippu");
    }

}
