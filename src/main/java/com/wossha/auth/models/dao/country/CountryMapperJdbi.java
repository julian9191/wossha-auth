package com.wossha.auth.models.dao.country;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapperJdbi implements ResultSetMapper<CountryRecord> {
	
	CountryRecord user = null;
	
    @Override
    public CountryRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CountryRecord(
                r.getInt("ID"),
                r.getString("NAME"),
                r.getString("CODE")
        );
    }
}