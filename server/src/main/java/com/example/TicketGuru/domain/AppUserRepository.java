package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	
	Optional<AppUser> findById(Long userId);
 
	// Hakee kaikki roolin käyttäjät
	Iterable<AppUser> findByRole(Role role);
 }
