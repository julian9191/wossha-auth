package com.wossha.auth.models.repository;

import com.wossha.auth.models.dao.UserDao;
import com.wossha.auth.models.dao.UserRecord;
import com.wossha.auth.models.dao.UserRoleRecord;
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
    
	public UserRecord findByUsername(String username){
		userDao = dbi.onDemand(UserDao.class);
        List<UserRecord> users = userDao.findByUsername(username);
        if(!users.isEmpty()) {
        	return users.get(0);
        }
		return null;
	}
	

    public void addUser(UserRecord user) {
    	userDao = dbi.open(UserDao.class);
    	
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	 UserRoleRecord userRole = new UserRoleRecord(user.getUsername(), RolesEnum.USER.getDescription());
        userDao.add(user, userRole);
        
        userDao.close();
    }

    @Override
    public String remove(UserRecord user) {
        return null;
    }

    @Override
    public UserRecord update(UserRecord user) {
        return null;
    }


	@Override
	public String add(UserRecord entity) {
		return null;
	}

}
