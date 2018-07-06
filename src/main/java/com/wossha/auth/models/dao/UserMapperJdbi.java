package com.wossha.auth.models.dao;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapperJdbi implements ResultSetMapper<UserRecord> {
	
	UserRecord user = null;
	
    @Override
    public UserRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
    	if (index == 0) {
    		user = new UserRecord(
                    r.getString("USERNAME"),
                    r.getString("PASSWORD"),
                    r.getString("FIRST_NAME"),
                    r.getString("LAST_NAME"),
                    r.getString("EMAIL"),
                    r.getBoolean("ENABLED"),
                    new ArrayList<String>()
            );
        }
    	user.getRoles().add(r.getString("ROLE_NAME"));
    	return user;
    }
}