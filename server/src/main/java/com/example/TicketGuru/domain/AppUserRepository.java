package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

	Optional<AppUser> findById(Long userId);

	AppUser findByEmail(String email);

	/*
	 * // JUnit testin hakua listasta varten, ei jostain syystä toimi
	 * List<AppUser> findByEmailFromList(String email);
	 */
}