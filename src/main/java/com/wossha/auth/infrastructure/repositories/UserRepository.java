package com.wossha.auth.infrastructure.repositories;

import com.wossha.auth.dto.ChatUserStatus;
import com.wossha.auth.dto.UserMinimumDTO;
import com.wossha.auth.infrastructure.dao.user.UserDao;
import com.wossha.auth.infrastructure.dao.user.UserRecord;
import com.wossha.auth.infrastructure.dao.user.UserRoleRecord;
import com.wossha.auth.infrastructure.enums.RolesEnum;
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
    
    public List<ChatUserStatus> getChatFriendsStatus(List<String> usernames) {
    	userDao = dbi.onDemand(UserDao.class); 
    	return userDao.getChatFriendsStatus(dbi, usernames);
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
    
    public List<UserMinimumDTO> searchUser(String word) {
    	userDao = dbi.onDemand(UserDao.class);
		word = "%" + word.toUpperCase() + "%";
		return userDao.searchUser(word);
	}
    
    public void updateOnlineStatus(String username, Integer status) {
    	userDao = dbi.onDemand(UserDao.class);
    	userDao.updateOnlineStatus(username, status);
	}

    public List<UserMinimumDTO> getMinimumUsersInfo(List<String> usernames) {
    	userDao = dbi.onDemand(UserDao.class);
		return userDao.getMinimumUsersInfo(dbi, usernames);
	}
    
    @Override
    public void remove(UserRecord user) {
    	
    }


	@Override
	public void add(UserRecord entity) {
		
	}

}
