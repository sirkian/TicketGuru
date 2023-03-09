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
import com.example.TicketGuru.domain.Role;

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
	
	// Palauttaa id:llä valitun roolin kaikki käyttäjät
	@GetMapping("/roles/{roleId}/appusers")
	public Iterable<AppUser> getAppUsersByRole(@PathVariable("roleId") Role role) {
		return auRepository.findByRole(role);
	}

	// Lisää uuden käyttäjän
	@PostMapping("/appusers")
	public AppUser newAppUser(@RequestBody AppUser newAppUser) {
		return auRepository.save(newAppUser);
	}

	// Muokkaa id:llä valittua käyttäjää
	@PutMapping("/appusers/{userId}")
	public AppUser editAppUser(@RequestBody AppUser editedAppUser, @PathVariable("userId") Long userId) {
		editedAppUser.setUserId(userId);
		return auRepository.save(editedAppUser);
	}

	// Poistaa id:llä haetun käyttäjän
	// Jätin vielä kommentteihin, pitäisikö tähänkin miettiä sitä soft deleteä mielummin?
	// @DeleteMapping("/appusers/{userId}")
	// public Iterable<AppUser> deleteAppUser(@PathVariable("userID") Long userId) {
	// auRepository.deleteById(userId);
	// return auRepository.findAll();
	// }

}
