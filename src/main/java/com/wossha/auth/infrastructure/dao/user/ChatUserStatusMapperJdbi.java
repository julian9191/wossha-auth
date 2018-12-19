package com.wossha.auth.infrastructure.dao.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.wossha.auth.dto.ChatUserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatUserStatusMapperJdbi implements ResultSetMapper<ChatUserStatus> {
	
	UserRecord user = null;
	
    @Override
    public ChatUserStatus map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new ChatUserStatus(
                r.getString("USERNAME"),
                r.getString("NAME"),
                r.getString("PROFILE_PICTURE"),
                r.getInt("IS_ONLINE")
        );
        
    }
}