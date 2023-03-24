package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Optional<Role> findById(Long roleID);
	
	// JUnit testiä varten luotu haku roolin nimellä
	Role findByRole(String role);
}
