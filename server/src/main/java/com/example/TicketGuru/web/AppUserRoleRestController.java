package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.AppUser_Role;
import com.example.TicketGuru.domain.AppUser_RoleRepository;

@RestController
public class AppUserRoleRestController {

	@Autowired
	private AppUser_RoleRepository userRoleRepository;
	
	@GetMapping("/appuserroles")
	public Iterable<AppUser_Role> getAllUserRoles() {
		return userRoleRepository.findAll();
	}
	
	@PostMapping("/appuserroles")
	public AppUser_Role newUserRole(@RequestBody AppUser_Role newUserRole) {
		return userRoleRepository.save(newUserRole);
	}
}
