package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import jakarta.validation.Valid;

@RestController
public class AppUserRestController {

	@Autowired
	private AppUserRepository auRepository;

	// Palauttaa kaikki käyttäjät
	@GetMapping("/appusers")
	public Iterable<AppUser> getAllAppUsers() {
		return auRepository.findAll();
	}

	// Palauttaa id:llä haetun käyttäjän
	@GetMapping("/appusers/{userId}")
	public Optional<AppUser> getAppUser(@PathVariable("userId") Long userId) {
		return auRepository.findById(userId);
	}

	// Lisää uuden käyttäjän
	@PostMapping("/appusers")
	public AppUser newAppUser(@Valid @RequestBody AppUser newAppUser) {
		return auRepository.save(newAppUser);
	}

	// Muokkaa id:llä valittua käyttäjää
	@PutMapping("/appusers/{userId}")
	public AppUser editAppUser(@Valid @RequestBody AppUser editedAppUser, @PathVariable("userId") Long userId) {
		editedAppUser.setUserId(userId);
		return auRepository.save(editedAppUser);
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
