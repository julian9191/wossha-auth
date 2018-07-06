package com.wossha.auth;

import javax.sql.DataSource;
import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wossha.auth.models.repository.UserRepository;

@SpringBootApplication
public class WosshaAuthApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(WosshaAuthApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub	
		String password = "123";
		
		for(int i=0; i<2; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println("-------------------->:"+bcryptPassword);
		}
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	@Bean
	public DBI dbi(DataSource dataSource) {
	    synchronized (DBI.class) {
	        return new DBI(dataSource);
	    }
	}
	
	@Bean
	public UserRepository userRpository() {
	    synchronized (UserRepository.class) {
	        return new UserRepository();
	    }
	}
	
}
