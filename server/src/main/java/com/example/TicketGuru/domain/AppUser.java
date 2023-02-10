package com.example.TicketGuru.domain;

import java.util.HashMap;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;



@Entity
@Table(name="app_user")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long TypeId;
	
	//Miten viiteavaimet merkitään?
	@Column(name = "role_id", nullable = false, updatable = false)
	private Long TypeRefId;
	
	@Column(name="first_name", length = 50, nullable = false, updatable = true)
	private String FirstName;
	
	@Column(name="last_name", length = 50, nullable = false, updatable = true)
	private String LastName;
	
	@Column(name="email", length = 150, nullable = false, updatable = true)
	private String Email;
	
	//Mikä olisi hyvä tietotyyppi salasanalle?
	@Column(name="password_hash", length = 450, nullable = false, updatable = true)
	private String Password;
	
	//Asetin tietotyypiksi stringin, jos halutaan käyttäjältä suuntanumero (+358..)
	@Column(name="phone_num", length = 15, nullable = false, updatable = true)
	private String PhoneNum;
	
	@Column(name="details", length = 450, nullable = true, updatable = true)
	private String Details;
	
	@Column(name="address", length = 250, nullable = false, updatable = true)
	private String Address;
	
	@Column(name="postal_code", length = 10, nullable = false, updatable = false)
	private int PostalCode;
}
