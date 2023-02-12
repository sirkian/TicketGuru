package com.example.TicketGuru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="app_user")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long userId;
	
	@Column(name="first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name="last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(name="email", length = 150, nullable = false)
	private String email;
	
	@Column(name="password_hash", length = 450, nullable = false)
	private String password;
	
	//Asetin tietotyypiksi stringin, jos halutaan käyttäjältä suuntanumero (+358..)
	@Column(name="phone_num", length = 15, nullable = false)
	private String phoneNum;
	
	@Column(name="details", length = 450, nullable = true)
	private String details;
	
	@Column(name="address", length = 250, nullable = false)
	private String address;
	
	// Tehdää välitaulu, jos halutaan yhelle käyttäjälle useempia rooleja
	// Nyt tässä kuitenkin monen suhde yhteen, eli roolilla voi olla monta käyttäjää, muttei toisinpäin
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id") 
	private Role role;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="postal_code")
	private PostalCode postalCode;
	
	public AppUser() { }

	public AppUser(String firstName, String lastName, String email, String password, String phoneNum,
			String details, String address, Role role, PostalCode postalCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.details = details;
		this.address = address;
		this.role = role;
		this.postalCode = postalCode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNum=" + phoneNum + ", details=" + details + ", address=" + address
				+ ", role=" + role + ", postalCode=" + postalCode + "]";
	}


	
	
	
	
	
}
