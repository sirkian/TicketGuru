package com.example.TicketGuru.service;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
=======
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
>>>>>>> e7f317a54caa7517cab18021957f514e16a45b6f
import org.springframework.stereotype.Service;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;

<<<<<<< HEAD

@Service
public class DetailsService implements UserDetailsService {
	private final AppUserRepository appusers;
	
=======
@Service
public class DetailsService implements UserDetailsService {

	private final AppUserRepository appusers;

>>>>>>> e7f317a54caa7517cab18021957f514e16a45b6f
	@Autowired
	public DetailsService(AppUserRepository appusers) {
		this.appusers = appusers;
	}
<<<<<<< HEAD
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appuser = appusers.findByEmail(email);
		
		UserBuilder builder = null;
		
=======

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appuser = appusers.findByEmail(email);

		UserBuilder builder = null;

>>>>>>> e7f317a54caa7517cab18021957f514e16a45b6f
		if (appuser == null) {
			throw new UsernameNotFoundException("Käyttäjää " + email + " ei löydetty!");
		} else {
			builder = org.springframework.security.core.userdetails.User.withUsername(email);
			builder.password(appuser.getPassword());
			builder.roles(appuser.getAppUserRoles().toString());
			System.out.println(appuser);
		}
<<<<<<< HEAD
		else {
			builder = org.springframework.security.core.userdetails.User.withUsername(email);
			builder.password(appuser.getPassword());
			builder.roles(appuser.getAppUserRoles().toString());
		}
=======
>>>>>>> e7f317a54caa7517cab18021957f514e16a45b6f
		return builder.build();
	}

}
