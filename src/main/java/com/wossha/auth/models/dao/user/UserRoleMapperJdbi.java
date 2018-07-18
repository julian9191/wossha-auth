package com.wossha.auth.models.dao.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRoleMapperJdbi implements ResultSetMapper<UserRoleRecord> {

	UserRecord user = null;

	@Override
	public UserRoleRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {

		return new UserRoleRecord(
				r.getLong("ID"),
				r.getString("USERNAME"), 
				r.getString("ROLE_NAME")
				);

	}
}