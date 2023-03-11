package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
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
		return typeRepository.findByTypeNameContainingIgnoreCase(name);
	}
	
	// luo uuden lipputyypin
	// esim http://localhost:8080/tickettypes [POST] Body: {"typeName": "Varusmies"}
	@PostMapping("/tickettypes")
	public TicketType newTicketType(@Valid @RequestBody TicketType newTicketType) {
		return typeRepository.save(newTicketType);
	}
	
	// muokkaa lipputyyppiä
	// esim http://localhost:8080/tickettypes/4 [PUT] Body: {"typeId": 4,"typeName": "LapsiMUOKATTU"}
	@PutMapping("/tickettypes/{typeId}")
	public TicketType editTicketType(@Valid @RequestBody TicketType editedType, @PathVariable("typeId") Long typeId) {
		editedType.setTypeId(typeId);
		return typeRepository.save(editedType);
	}
	
	
	// poistaa lipputyypin soft deletellä
	// lipputyypit vaikuttaa kaikkiin tapahtumiin, ei voi poistaa kokonaan, jos
	// valittu yhdellekään tapahtumalle
	
}
