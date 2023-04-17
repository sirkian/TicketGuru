package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	// Etsitään maksutapahtumaa transaction_id:n perusteella.
	// Optional, koska hakuterminä käytettävällä id:llä ei välttämättä ole maksutapahtumaa.
	Optional<Transaction> findById(Long transactionId);

	Transaction getById(Long transactionId);
}
