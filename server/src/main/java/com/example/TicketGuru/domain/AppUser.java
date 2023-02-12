package com.example.TicketGuru.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postal_code")
	private List<Postalcode> postalcodes;
	
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setPostalcodes(List<Postalcode> postalcodes) {
		this.postalcodes = postalcodes;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getDetails() {
		return details;
	}

	public String getAddress() {
		return address;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public Role getRole() {
		return role;
	}

	public List<Postalcode> getPostalcodes() {
		return postalcodes;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", roleId=" + roleId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", phoneNum=" + phoneNum + ", details="
				+ details + ", address=" + address + ", postalCode=" + postalCode + "]";
	}

	
	
}
