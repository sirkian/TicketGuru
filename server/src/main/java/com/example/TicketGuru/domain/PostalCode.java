package com.example.TicketGuru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;


@Entity
public class PostalCode {

    @Id
    // Otin tästä autogenin pois, että voidaa ite asettaa postikoodi / PK
    // Ja joutu muuttaa tyypin Stringiks, kokonaislukuna 00100 tulostu ja tallentu kantaan lukuna 64 :D
    // https://stackoverflow.com/a/7218803
    
    @Pattern(regexp = "[0-9]{5}")
    @Column(name = "postal_id", nullable = false, updatable = false, unique = true)
    private String postalCode;

    @Pattern(regexp = "[a-zA-ZåäöÅÄÖ -]{1,100}")
    @Column(name = "city")
    private String city;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postalCode")
    private List<Venue> venues;
    
    
    public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

	public PostalCode() { }

    public PostalCode(String postalCode, String city) {
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	@Override
	public String toString() {
		return "PostalCode [postalCode=" + postalCode + ", city=" + city + ", venues=" + venues + "]";
	}

    
}
