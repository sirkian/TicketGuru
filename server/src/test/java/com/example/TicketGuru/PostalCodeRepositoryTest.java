package com.example.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;

@DataJpaTest
@ActiveProfiles("dev")
public class PostalCodeRepositoryTest {

    @Autowired
    private PostalCodeRepository pcRepository;

    @Test
    public void createPostalCode() {
        PostalCode postalCodetest = new PostalCode("00720", "Helsinki");
        pcRepository.save(postalCodetest);
        assertThat(postalCodetest.getPostalCode()).isEqualTo("00720");
    }

}
