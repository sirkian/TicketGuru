package com.example.TicketGuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;

public class DetailsService implements UserDetailsService {
	
	@Autowired
	AppUserRepository appusers;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appuser = appusers.findByEmail(email);
		if (appuser == null) {
			throw new UsernameNotFoundException("Käyttäjää " + email + " ei löydetty!");
		}
		return new org.springframework.security.core.userdetails.User(
				appuser.getEmail(),
				appuser.getPassword(),
				AuthorityUtils.createAuthorityList(appuser.getAppUserRoles().toString())
				);
	}
	

}
