package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;


/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class AppUserDetailsService implements UserDetailsService  {
	private final AppUserRepository repository;

	@Autowired
	public AppUserDetailsService(AppUserRepository appuserRepository) {
		this.repository = appuserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException

	{   
		AppUser curruser = repository.findByEmail(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(), 
				AuthorityUtils.createAuthorityList(curruser.getEmail()));
		return user;
	} 
	

}
