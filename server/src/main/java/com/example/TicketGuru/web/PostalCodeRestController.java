package com.example.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;

import jakarta.validation.Valid;

@RestController

public class PostalCodeRestController {

	@Autowired
	PostalCodeRepository pcrepository;

	// Palauttaa kaikki postinumerot
	@GetMapping("/postalcodes")
	public Iterable<PostalCode> getAllPostalCodes() {

		return pcrepository.findAll();
	}

	// Palauttaa kaikki postinumerot joiden kaupunki sisältää hakusanan
	@GetMapping("/postalcodes/q")
	public Iterable<PostalCode> getPostalCodesByName(@RequestParam(value = "city") String city) {

		return pcrepository.findByCityContainingIgnoreCase(city);
	}

	// Lisää uuden postinumeron
	// lähetä vastaus, jos on jo olemassa -> ei anna luoda samaa, mutta ei
	// vastaakaan mitään
	@PostMapping("/postalcodes")
	@ResponseStatus(HttpStatus.CREATED)
	public PostalCode newPostalCode(@Valid @RequestBody PostalCode newPostalCode) {
		Optional<PostalCode> pcode = pcrepository.findByPostalCode(newPostalCode.getPostalCode());
		if (pcode.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Annettu postinumero on jo käytössä");
		}
		return pcrepository.save(newPostalCode);
	}

	// Muokkaa valittua postinumeroa
	@PutMapping("/postalcodes/{postalCode}")
	public PostalCode editPostalCode(@Valid @RequestBody PostalCode editedPostalCode,
			@PathVariable("postalCode") String postalCode) {

		Optional<PostalCode> postcode = pcrepository.findByPostalCode(postalCode);
		if (postcode.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annettua postinumeroa ei löydy");
		}
		// tästä puuttuu tarkistus cityn sisällölle -> jos sisältää numeron??
		editedPostalCode.setPostalCode(postalCode);
		return pcrepository.save(editedPostalCode);
	}

	// listaa postinumeroon liittyvät tapahtumapaikat?

}
