package com.wossha.auth.infrastructure.dao.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.wossha.auth.commands.modifyuser.model.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRoleMapperJdbi implements ResultSetMapper<UserRoleRecord> {

	UserDTO user = null;

	@Override
	public UserRoleRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {

		return new UserRoleRecord(
				r.getLong("ID"),
				r.getString("USERNAME"), 
				r.getString("ROLE_NAME")
				);

	}
}