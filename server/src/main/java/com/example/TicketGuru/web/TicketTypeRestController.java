package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.TicketGuru.domain.TicketType;
import com.example.TicketGuru.domain.TicketTypeRepository;

import jakarta.validation.Valid;

@RestController
public class TicketTypeRestController {
	
	@Autowired
	TicketTypeRepository typeRepository;

	// palauttaa listan lipputyypeistä
	@GetMapping("/tickettypes")
	public Iterable<TicketType> getTicketTypes(){
		
		return typeRepository.findAll();
	}
	
	// hakee lippytyypin nimellä
	// esim. http://localhost:8080/tickettypes/q?name=Opiskelija-lippu
	// tai http://localhost:8080/tickettypes/q?name=Opiskelija
	@GetMapping("tickettypes/q")
	public Iterable<TicketType> getTicketTypeByName(@RequestParam(value = "name") String name){
		if (name.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nimeä vastaavaa lippua ei löytynyt");
		}
		return typeRepository.findByTypeNameContainingIgnoreCase(name);
		
	}
	
	// luo uuden lipputyypin
	// esim http://localhost:8080/tickettypes [POST] Body: {"typeName": "Varusmies"}
	@PostMapping("/tickettypes")
	@ResponseStatus(HttpStatus.CREATED)
	public TicketType newTicketType(@Valid @RequestBody TicketType newTicketType) {
		try {
			return typeRepository.save(newTicketType);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	
	// muokkaa lipputyyppiä
	// esim http://localhost:8080/tickettypes/4 [PUT] Body: {"typeId": 4,"typeName": "LapsiMUOKATTU"}
	@PutMapping("/tickettypes/{typeId}")
	public TicketType editTicketType(@Valid @RequestBody TicketType editedType, @PathVariable("typeId") Long typeId) {
		Optional<TicketType> type = typeRepository.findById(typeId);
		if ((type.isPresent())) {
			try {
		editedType.setTypeId(typeId);
		return typeRepository.save(editedType);
		}
			catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarkista viiteavaimet: " + e.getMessage());
			}				
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annetulla id:llä ei ole olemassa lipputyyppiä");	
		}

	}
	
	
	
	// poistaa lipputyypin soft deletellä
	// lipputyypit vaikuttaa kaikkiin tapahtumiin, ei voi poistaa kokonaan, jos
	// valittu yhdellekään tapahtumalle
	
}
