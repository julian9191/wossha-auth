package com.wossha.auth.infrastructure.services.model;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SessionInfo extends User{
	
	UserSessionInfo userSessionInfo;

	public SessionInfo(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public UserSessionInfo getUserSessionInfo() {
		return userSessionInfo;
	}

	public void setUserSessionInfo(UserSessionInfo userSessionInfo) {
		this.userSessionInfo = userSessionInfo;
	}

	private static final long serialVersionUID = 1L;
}
