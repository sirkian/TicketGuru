package com.example.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;

@DataJpaTest
public class PostalCodeRepositoryTest {

	@Autowired
	private PostalCodeRepository pcRepository;
	
	/*
	 tätä en saanut toimimaan..
	 
	@BeforeEach
	public void clearDatabaseBeforeTest() {
		pcRepository.deleteAll();
	}
	
	*/
	// testataan postinumeron luonti
	
	@Test
	public void createPostalCode() {
		PostalCode postalCodetest = new PostalCode("00720", "Helsinki");
		pcRepository.save(postalCodetest);
		assertThat(postalCodetest.getPostalCode()).isEqualTo("00720");
	}
	
	
	@Test
	public void shouldFindAll() {
		
		PostalCode pC1 = new PostalCode("00720", "Helsinki");
		PostalCode pC2 = new PostalCode("00700", "Vantaa");
		PostalCode pC3 = new PostalCode("00990", "Oulu");
		
		pcRepository.save(pC1);
		pcRepository.save(pC2);
		pcRepository.save(pC3);
		
		Iterable<PostalCode> pCodes = pcRepository.findAll();
		
		assertThat(pCodes).hasSize(5);
		// kun commandlinerunnerista poistettu tavarat, testi on muotoa
		// (olettaen, että: tietokannan saa tyhjennettyä ensin)
		//assertThat(pCodes).hasSize(3).contains(pC1, pC2, pC3);
		// https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
	}
}
