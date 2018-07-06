package com.wossha.auth;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.spring.DBIFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import oracle.jdbc.pool.OracleDataSource;

@SpringBootApplication
public class WosshaAuthApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(WosshaAuthApplication.class, args);
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
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("WSSAUTHCXN1");
        dataSource.setPassword("WSSAUTHCXN1");
        dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
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
}
