package com.wossha.auth.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wossha.auth.infrastructure.filters.JWTAuthenticationFilter;
import com.wossha.auth.infrastructure.filters.JWTAuthorizationFilter;
import com.wossha.auth.infrastructure.services.JWTService;
import com.wossha.auth.infrastructure.services.JdbiUserDetailsService;

@Configuration
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("${external.properties}")
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private JdbiUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		String password = "123";
		for(int i=0; i<2; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println("-------------------->:"+bcryptPassword);
		}
		
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/users/register-user", "/countries").permitAll()
		.anyRequest().authenticated()
		.and()
		.cors().and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService))
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
	}
}
