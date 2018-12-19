package com.wossha.auth.infrastructure.dao.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.auth.dto.UserSearchDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSearchMapperJdbi implements ResultSetMapper<UserSearchDTO> {
	
	UserRecord user = null;
	
    @Override
    public UserSearchDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new UserSearchDTO(
                r.getString("USERNAME"),
                r.getString("NAME"),
                r.getString("PROFILE_PICTURE")
        );
        
    }
}