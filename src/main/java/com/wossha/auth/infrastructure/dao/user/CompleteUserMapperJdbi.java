package com.wossha.auth.infrastructure.dao.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.wossha.auth.commands.modifyuser.model.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompleteUserMapperJdbi implements ResultSetMapper<UserRecord> {
	
	UserRecord user = null;
	
    @Override
    public UserRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
    	if (index == 0) {
    		user = new UserRecord(
                    r.getString("USERNAME"),
                    r.getString("PASSWORD"),
                    r.getString("FIRST_NAME"),
                    r.getString("LAST_NAME"),
                    r.getString("GENDER"),
                    r.getString("EMAIL"),
                    r.getInt("COUNTRY_ID"),
                    r.getString("ABOUT"),
                    r.getBoolean("ENABLED"),
                    r.getTimestamp("BIRTHDAY"),
                    new ArrayList<String>()
            );
        }
    	try {
    		user.getRoles().add(r.getString("ROLE_NAME"));
    	}catch (SQLException e) {}
    	
    	return user;
    }
}