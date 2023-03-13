package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TicketGuru.domain.Role;
import com.example.TicketGuru.domain.RoleRepository;

import jakarta.validation.Valid;

@RestController
public class RoleRestController {

	@Autowired
	RoleRepository rolerepository;
	
	// Palauttaa id:llä haetun roolin
		@GetMapping("/roles/{roleId}")
		public Optional<Role> getRole(@PathVariable("roleId") Long roleId) {
			Optional<Role> role = rolerepository.findById(roleId);
			if (role.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei löytynyt yhtään roolia");
			}
			return rolerepository.findById(roleId);
		}
		
	//Palauttaa kaikki roolit
		@GetMapping("/roles")
		public Iterable<Role> getAllRoles() {
			return rolerepository.findAll();
		}
		
	//Lisää roolin
		@PostMapping("/roles")
		@ResponseStatus(HttpStatus.CREATED)
		public Role newRole(@Valid @RequestBody Role newRole) {
			try {
				return rolerepository.save(newRole);
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}
		}
		
	
}
