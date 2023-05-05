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

	// haetaan tapahtuman lipputyypit
	//Iterable <EventTicketType> findByEventId(Long eventId);

	// Hakee tapahtuman id:n perusteella kaikki luodut liput
	// Palauttaa löydettyjen lippujen määrän
	@Query(value = "SELECT COUNT(TICKET_ID) FROM TICKET WHERE EVENT_TYPE_ID IN (SELECT  EVENT_TYPE_ID  FROM EVENT_TICKET_TYPE WHERE EVENT_ID = :eventId)", nativeQuery = true)
	Integer getAmountOfSoldTickets(@Param("eventId") Long EventId);

	// laskee tapahtuman id:n ja lipputyypin perusteella kaikki luodut liput (raportti)
	// esim tapahtumassa 1 lastenlippuja luotu (=myyty) 10 kpl
	// palauttaalöydettyjen lippujen määrän
	@Query(value = "SELECT COUNT(TICKET_ID) FROM TICKET WHERE EVENT_TYPE_ID IN (SELECT  EVENT_TYPE_ID  FROM EVENT_TICKET_TYPE WHERE EVENT_ID = :eventId AND TYPE_ID= :typeId)", nativeQuery = true)
	Integer getAmountOfSoldTicketsOfTicketType(@Param("eventId") Long EventId, @Param("typeId") Long TypeId);
}

