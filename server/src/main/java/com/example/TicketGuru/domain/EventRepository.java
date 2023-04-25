package com.example.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends CrudRepository<Event, Long> {

	Optional<Event> findById(Long eventId);

	// Hakee tapahtumat, joiden nimi sisältää hakusanan, välittämättä kirjainten
	// koosta
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	Iterable<Event> findByEventNameContainingIgnoreCase(String eventName);

	// Hakee kaikki tapahtumapaikan tapahtumat
	// Sama toiminto kuin venues/id/events, mutta nätimpi formaatti responsessa
	Iterable<Event> findByVenue(Optional<Venue> optional);

	Event getByEventTicketTypes(EventTicketType ett);

	// Hakee tapahtuman id:n perusteella kaikki luodut liput
	// Palauttaa löydettyjen lippujen määrän
	@Query(value = "SELECT COUNT(TICKET_ID) FROM TICKET WHERE EVENT_TYPE_ID IN (SELECT  EVENT_TYPE_ID  FROM EVENT_TICKET_TYPE WHERE EVENT_ID = :eventId)", nativeQuery = true)
	Integer getAmountOfSoldTickets(@Param("eventId") Long EventId);
}
