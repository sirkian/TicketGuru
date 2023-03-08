package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;

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
	@PostMapping("/postalcodes")
	public PostalCode newPostalCode(@RequestBody PostalCode newPostalCode) {
		return pcrepository.save(newPostalCode);
	}
	
	// Muokkaa valittua postinumeroa
	@PutMapping("/postalcodes/{postalCode}")
	public PostalCode editPostalCode(@RequestBody PostalCode editedPostalCode, @PathVariable("postalCode") String postalCode) {
		editedPostalCode.setPostalCode(postalCode);
		return pcrepository.save(editedPostalCode);
	}
	
}
