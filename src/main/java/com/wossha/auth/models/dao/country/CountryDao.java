package com.wossha.auth.models.dao.country;

import java.util.List;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;

@Repository
@RegisterMapper(CountryMapperJdbi.class)
public abstract  class CountryDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
    @SqlQuery("SELECT * FROM TWSS_COUNTRIES ORDER BY NAME")
    public abstract List<CountryRecord> findAll();
    
    
    
    public abstract void close();

}