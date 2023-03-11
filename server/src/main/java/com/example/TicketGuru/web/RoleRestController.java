package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
			return rolerepository.findById(roleId);
		}
		
	//Palauttaa kaikki roolit
		@GetMapping("/roles")
		public Iterable<Role> getAllRoles() {
			return rolerepository.findAll();
		}
		
	//Lisää roolin
		@PostMapping("/roles")
		public Role newRole(@Valid @RequestBody Role newRole) {
			return rolerepository.save(newRole);
		}
		
	
}
