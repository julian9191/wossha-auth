package com.wossha.auth.infrastructure.dao.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapperJdbi implements ResultSetMapper<UserRecord> {
	
	UserRecord user = null;
	
    @Override
    public UserRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new UserRecord(
                r.getString("USERNAME"),
                r.getString("FIRST_NAME"),
                r.getString("LAST_NAME"),
                r.getString("GENDER"),
                r.getString("EMAIL"),
                r.getInt("COUNTRY_ID"),
                r.getString("ABOUT"),
                r.getTimestamp("BIRTHDAY")
        );
        
    }
}