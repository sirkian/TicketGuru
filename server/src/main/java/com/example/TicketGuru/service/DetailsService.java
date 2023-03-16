package com.example.TicketGuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.AuthorityUtils;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUser_Role;
import com.example.TicketGuru.domain.AppUser_RoleRepository;

import com.example.TicketGuru.domain.AppUserRepository;

@Service
public class DetailsService implements UserDetailsService {

	private final AppUserRepository appusers;

	@Autowired
	public DetailsService(AppUserRepository appusers) {
		this.appusers = appusers;
	}

	@Autowired
	private AppUser_RoleRepository userRoleRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		AppUser appuser = appusers.findByEmail(email);

		if (appuser == null) {
			throw new UsernameNotFoundException("Käyttäjää " + email + " ei löydetty!");
		}

		String roles = "";
		// Haetaan AppUser_RoleRepositorysta kaikki käyttäjän AppUserRolet
		// Käydään roolit läpi ja konkatenoidaan roles-merkkijonoon pilkulla erotettuna
		for (AppUser_Role role : userRoleRepo.findByAppUser(appuser)) {
			roles += role.getRole().getRole().toUpperCase() + ", ";
		}

		// Luodaan UserDetails-olio spostilla, salasanalla ja roolit-merkkijonolla
		UserDetails user = new org.springframework.security.core.userdetails.User(email, appuser.getPassword(),
				AuthorityUtils.commaSeparatedStringToAuthorityList(roles));

		return user;
	}

}