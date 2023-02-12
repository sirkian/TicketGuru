package com.example.TicketGuru.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostalCodeRepository extends CrudRepository<PostalCode, Long> {

    Optional<PostalCode> findById(Long PostalCode);
}
