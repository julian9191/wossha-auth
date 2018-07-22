package com.wossha.auth.models.repository;

import com.wossha.auth.models.dao.user.UserDao;
import com.wossha.auth.models.dao.user.UserRecord;
import com.wossha.auth.models.dao.user.UserRoleRecord;
import com.wossha.auth.models.enums.RolesEnum;
import java.util.List;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRepository implements Repository<UserRecord> {

	@Autowired
	private IDBI dbi;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private UserDao userDao;
    
	public UserRecord findCompleteByUsername(String username){
		userDao = dbi.onDemand(UserDao.class);
        List<UserRecord> users = userDao.findCompleteByUsername(username);
        if(!users.isEmpty()) {
        	return users.get(0);
        }
		return null;
	}
	
    public UserRecord findUserByUsername(String username) {
    	userDao = dbi.onDemand(UserDao.class);
    	return userDao.findByUsername(username);
	}
    
    public UserRecord findUserByUsernameOrEmail(String username, String email) {
    	userDao = dbi.onDemand(UserDao.class);
    	return userDao.findByUsernameOrEmail(username, email);
	}
	

    public void addUser(UserRecord user) {
    	userDao = dbi.open(UserDao.class);
    	
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	 UserRoleRecord userRole = new UserRoleRecord(user.getUsername(), RolesEnum.USER.getDescription());
        userDao.add(user, userRole);
        
        userDao.close();
    }
    
    @Override
    public void update(UserRecord user) {
    	userDao = dbi.onDemand(UserDao.class);
    	userDao.update(user);
    }

    @Override
    public void remove(UserRecord user) {
    	
    }


	@Override
	public void add(UserRecord entity) {
		
	}

	

}
