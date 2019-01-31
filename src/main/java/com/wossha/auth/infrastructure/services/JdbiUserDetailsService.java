package com.wossha.auth.infrastructure.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wossha.auth.infrastructure.dao.user.UserRecord;
import com.wossha.auth.infrastructure.repositories.UserRepository;
import com.wossha.auth.infrastructure.services.model.SessionInfo;
import com.wossha.auth.infrastructure.services.model.UserSessionInfo;


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
        
        SessionInfo userSesionInfo =  new SessionInfo(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
        try {
        	UserSessionInfo userSessionInfo = new UserSessionInfo(URLEncoder.encode(user.getFirstName(), "UTF-8"), URLEncoder.encode(user.getLastName(), "UTF-8"), user.getProfilePicture());
			String prueba = URLDecoder.decode(user.getFirstName(), "UTF-8");
        	userSesionInfo.setUserSessionInfo(userSessionInfo);

        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        
		return userSesionInfo;
	}

}
