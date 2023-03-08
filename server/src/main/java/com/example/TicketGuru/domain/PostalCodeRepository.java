package com.example.TicketGuru.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostalCodeRepository extends CrudRepository<PostalCode, Long> {

    Optional<PostalCode> findById(Long PostalCode);
    
    // Hakee postinumerot, joiden kaupungin nimi sisältää hakusanan (kirjainkoolla ei ole väliä)
    Iterable<PostalCode> findByCityContainingIgnoreCase(String city);
}
