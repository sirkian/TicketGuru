package com.example.TicketGuru.domain;

import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppUser_RoleRepository extends CrudRepository<AppUser_Role, Long> {

	Optional<AppUser_Role> findById(Long appUserRoleId);

	Iterable<AppUser_Role> findByAppUser(Optional<AppUser> user);

	List<AppUser_Role> findByAppUser(AppUser user);
}
