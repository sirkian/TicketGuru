package com.example.TicketGuru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Välitaulu, jolla mahdollistetaan yhdelle käyttäjälle monta roolia
// PK user_role_id
// FK user_id
// FK role_id

// FK luokilla OneToMany suhde tähän

@Entity
public class AppUser_Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id", nullable = false, updatable = false)
	private Long appUserRoleId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AppUser appUser;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	public AppUser_Role() {}

	public AppUser_Role(Long appUserRoleId, AppUser appUser, Role role) {
		super();
		this.appUserRoleId = appUserRoleId;
		this.appUser = appUser;
		this.role = role;
	}

	public Long getAppUserRoleId() {
		return appUserRoleId;
	}

	public void setAppUserRoleId(Long appUserRoleId) {
		this.appUserRoleId = appUserRoleId;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AppUser_Role [appUserRoleId=" + appUserRoleId + ", appUser=" + appUser + ", role=" + role + "]";
	}
	
	

}
