package com.wossha.auth.models.service;

import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.IDBI;
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

import com.wossha.auth.models.dao.UserDao;
import com.wossha.auth.models.dao.UserRecord;

//import com.bolsadeideas.springboot.app.models.dao.IUsuarioDao;
//import com.bolsadeideas.springboot.app.models.entity.Role;

@Service("jpaUserDetailsService")
public class JdbiUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IDBI dbi;
	
	private UserDao userDao;
	
	private Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		userDao = dbi.onDemand(UserDao.class);
        List<UserRecord> users = userDao.findByUsername(username);
       
        if(users.isEmpty()) {
        	logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        UserRecord user = users.get(0);
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        for(String role: user.getRoles()) {
        	logger.info("Role: "+role);
        	authorities.add(new SimpleGrantedAuthority(role));
        }
        
        if(authorities.isEmpty()) {
        	logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        
		return new User(user.getUsername(), user.getPassword(), true/*user.getEnabled()*/, true, true, true, authorities);
	}

}
