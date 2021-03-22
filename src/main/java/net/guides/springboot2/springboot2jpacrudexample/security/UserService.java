package net.guides.springboot2.springboot2jpacrudexample.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	public UserDetails loadUserByUsername(String username);

}
