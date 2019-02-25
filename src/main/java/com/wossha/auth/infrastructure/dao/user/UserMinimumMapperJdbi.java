package com.wossha.auth.infrastructure.dao.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.auth.dto.UserMinimumDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMinimumMapperJdbi implements ResultSetMapper<UserMinimumDTO> {
	
	UserRecord user = null;
	
    @Override
    public UserMinimumDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new UserMinimumDTO(
                r.getString("USERNAME"),
                r.getString("NAME"),
                r.getString("PROFILE_PICTURE")
        );
        
    }
}