package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import jakarta.validation.Valid;

@RestController
public class AppUserRestController {

	@Autowired
	private AppUserRepository auRepository;

	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	// Palauttaa kaikki käyttäjät
	@GetMapping("/appusers")
	public Iterable<AppUser> getAllAppUsers() {
		return auRepository.findAll();
	}

	// Palauttaa id:llä haetun käyttäjän
	@GetMapping("/appusers/{userId}")
	public Optional<AppUser> getAppUser(@PathVariable("userId") Long userId) {
		Optional<AppUser> user = auRepository.findById(userId);
		if (user.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id:llä ei löytynyt käyttäjää");
		}
		return auRepository.findById(userId);
	}

	// Lisää uuden käyttäjän
	@PostMapping("/appusers")
	@ResponseStatus(HttpStatus.CREATED)
	public AppUser newAppUser(@Valid @RequestBody AppUser newAppUser) {
		try {
			String pwdHash = bcrypt.encode(newAppUser.getPassword());
			newAppUser.setPassword(pwdHash);
			return auRepository.save(newAppUser);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// Muokkaa id:llä valittua käyttäjää
	@PutMapping("/appusers/{userId}")
	public AppUser editAppUser(@Valid @RequestBody AppUser editedAppUser, @PathVariable("userId") Long userId) {
		Optional<AppUser> user = auRepository.findById(userId);
		if ((user.isPresent())) {
			try {
				editedAppUser.setUserId(userId);
				String pwdHash = bcrypt.encode(editedAppUser.getPassword());
				editedAppUser.setPassword(pwdHash);
				return auRepository.save(editedAppUser);
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarkista viiteavaimet: " + e.getMessage());
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei ole olemassa käyttäjää");
		}

	}

	// Poistaa id:llä haetun käyttäjän
	// Jätin vielä kommentteihin, pitäisikö tähänkin miettiä sitä soft deleteä
	// mielummin?
	// @DeleteMapping("/appusers/{userId}")
	// public Iterable<AppUser> deleteAppUser(@PathVariable("userID") Long userId) {
	// auRepository.deleteById(userId);
	// return auRepository.findAll();
	// }

}
