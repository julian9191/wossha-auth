package com.wossha.auth.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wossha.auth.models.dao.UserRecord;
import com.wossha.auth.models.repository.UserRepository;


@Service("jpaUserDetailsService")
public class JdbiUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	
	private Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        UserRecord user = repo.findCompleteByUsername(username);
       
        if(user == null) {
        	logger.error("Login error: the user '" + username + "' doesn't exists");
        	throw new UsernameNotFoundException("Username: " + username + " doesn't exists");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        for(String role: user.getRoles()) {
        	logger.info("Role: "+role);
        	authorities.add(new SimpleGrantedAuthority(role));
        }
        
        if(authorities.isEmpty()) {
        	logger.error("Login error: the user'" + username + "' doesn't have assigned roles");
        	throw new UsernameNotFoundException("Login error: the user '" + username + "' doesn't have assigned roles");
        }
        
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

}
