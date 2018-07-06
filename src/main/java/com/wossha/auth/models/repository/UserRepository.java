package com.wossha.auth.models.repository;

import com.wossha.auth.models.dao.UserDao;
import com.wossha.auth.models.dao.UserRecord;

import java.util.List;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepository implements Repository<UserRecord> {

	@Autowired
	private IDBI dbi;
	
	private UserDao userDao;
    
	public UserRecord findByUsername(String username){
		userDao = dbi.onDemand(UserDao.class);
        List<UserRecord> users = userDao.findByUsername(username);
        if(!users.isEmpty()) {
        	return users.get(0);
        }
		return null;
	}
	
    @Override
    public String add(UserRecord user) {
		return null;
    }

    @Override
    public String remove(UserRecord user) {
        return null;
    }

    @Override
    public UserRecord update(UserRecord user) {
        return null;
    }

}
