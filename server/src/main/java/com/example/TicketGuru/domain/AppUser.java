package com.example.TicketGuru.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="app_user")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long userId;
	
	//Miten viiteavaimet merkitään?
	//Yhdelle käyttäjälle vain yksi rooli
	//JsonIgnore
	//ei konstruktoriin eikä toString
	(name = "role_id", nullable = false, updatable = false)
	private Long roleId;
	
	@Column(name="first_name", length = 50, nullable = false, updatable = true)
	private String firstName;
	
	@Column(name="last_name", length = 50, nullable = false, updatable = true)
	private String lastName;
	
	@Column(name="email", length = 150, nullable = false, updatable = true)
	private String email;
	
	//Mikä olisi hyvä tietotyyppi salasanalle?
	@Column(name="password_hash", length = 450, nullable = false, updatable = true)
	private String password;
	
	//Asetin tietotyypiksi stringin, jos halutaan käyttäjältä suuntanumero (+358..)
	@Column(name="phone_num", length = 15, nullable = false, updatable = true)
	private String phoneNum;
	
	@Column(name="details", length = 450, nullable = true, updatable = true)
	private String details;
	
	@Column(name="address", length = 250, nullable = false, updatable = true)
	private String address;
	
	@Column(name="postal_code", length = 10, nullable = false, updatable = false)
	private int postalCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id") 
	private Role role;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private Postalcode postalCode;
	
	
}
