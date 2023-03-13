package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.TicketGuru.domain.AppUser_Role;
import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUser_RoleRepository;
import com.example.TicketGuru.domain.AppUserRepository;

import jakarta.validation.Valid;

@RestController
public class AppUserRoleRestController {

	@Autowired
	private AppUser_RoleRepository userRoleRepository;

	@Autowired
	private AppUserRepository userRepository;

	@GetMapping("/appuserroles")
	public Iterable<AppUser_Role> getAllUserRoles() {
		return userRoleRepository.findAll();
	}

	// Haetaan kaikki käyttäjän roolit
	@GetMapping("/appusers/{userId}/appuserroles")
	public Iterable<AppUser_Role> getAllUserRolesByUser(@PathVariable("userId") Long userId) {
		Optional<AppUser> user = userRepository.findById(userId);
		if (user.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id:llä ei löytynyt käyttäjää");
		}
		return userRoleRepository.findByAppUser(user);
	}

	@PostMapping("/appuserroles")
	@ResponseStatus(HttpStatus.CREATED)
	public AppUser_Role newUserRole(@Valid @RequestBody AppUser_Role newUserRole) {
		try {
			return userRoleRepository.save(newUserRole);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/appuserroles/{appUserRoleId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAppUserRole(@PathVariable("appUserRoleId") Long appUserRoleId) {
		try {
			userRoleRepository.deleteById(appUserRoleId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Poisto epäonnistui, id:tä ei löytynyt");
		}

	}

}
