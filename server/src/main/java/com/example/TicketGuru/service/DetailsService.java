package com.example.TicketGuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;


@Service
public class DetailsService implements UserDetailsService {
	private final AppUserRepository appusers;
	
	@Autowired
	public DetailsService(AppUserRepository appusers) {
		this.appusers = appusers;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appuser = appusers.findByEmail(email);
		
		UserBuilder builder = null;
		
		if (appuser == null) {
			throw new UsernameNotFoundException("Käyttäjää " + email + " ei löydetty!");
		}
		else {
			builder = org.springframework.security.core.userdetails.User.withUsername(email);
			builder.password(appuser.getPassword());
			builder.roles(appuser.getAppUserRoles().toString());
		}
		return builder.build();
	}
	

}
