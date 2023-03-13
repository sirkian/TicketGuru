package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Optional<Role> findById(Long roleID);
}
