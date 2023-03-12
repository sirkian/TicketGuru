package com.example.TicketGuru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false, updatable = false)
	private Long roleId;
	
	@Column(name = "role", length=50)
	@NotBlank
	@Size(max = 50)
	private String role;
	
	// Lisätty välitaulu AppUser_Role
	// Nyt en oo kyllä satavarma tarvittaisko tätä oneToMany-suhdetta oikeesti
	// Tai siis, tuskin tarvii ikinä hakee role.getAppUserRoles(), mutta pelataa varman päälle
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private List<AppUser_Role> appUserRoles;
	
	public Role() { 
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<AppUser_Role> getAppUserRoles() {
		return appUserRoles;
	}

	public void setAppUserRoles(List<AppUser_Role> appUserRoles) {
		this.appUserRoles = appUserRoles;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + "]";
	}



	
	
	
	

}
