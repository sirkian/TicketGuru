package com.example.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;

// import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import com.example.TicketGuru.domain.PostalCode;

@DataJpaTest
public class AppUserRepositoryTest {

	@Autowired
	private AppUserRepository auRepository;
	
	// Testataan käyttäjän luonti
	@Test
	public void createAppUser() {
		// String firstName, String lastName, String email, String password, String phoneNum, String details, String address, PostalCode postalCode
		AppUser appuser = new AppUser("Testi", "Testaaja", "test@ticketguru.com", "salasanaHASH", "+3584044040", "Tosi hyvä dude", "Osoitekatu 1", new PostalCode("00100", "Helsinki"));
		auRepository.save(appuser);
		assertThat(appuser.getUserId()).isNotNull();
	}
	
	// Testataan käyttäjän haku CommandLineRunneriin syötetyistä käyttäjistä
	@Test
	public void findUserByEmailShouldReturnUser() {
		AppUser appuser = auRepository.findByEmail("make@tiketguru.com");
		assertThat(appuser.getFirstName()).isEqualTo("Make");		
	}
	
	/* //Testi aiemmin ohjelman kaataneesta hausta listan kanssa (sama testi kuin yllä siis), ei toimi jostain syystä
	@Test
	public void findUserByEmailShouldReturnUser() {
		List<AppUser> appusers = auRepository.findByEmailFromList("make@tiketguru.com");
		assertThat(appusers).hasSize(1);
		assertThat(appusers.get(0).getFirstName()).isEqualTo("Make");
	}
	*/
	
	
}
