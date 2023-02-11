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

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false, updatable = false)
	private Long roleId;
	
	@Column(name = "role", length=50)
	private String role;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private List<Role> roles;
	
	public Role() {
		super();
	}

	public Role(Long roleId, String role, List<Role> roles) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.roles = roles;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}

	
	
	
	

}
