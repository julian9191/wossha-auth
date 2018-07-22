package com.wossha.auth.models.repository;

import com.wossha.auth.models.dao.country.CountryDao;
import com.wossha.auth.models.dao.country.CountryRecord;
import java.util.List;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryRepository implements Repository<CountryRecord> {

	@Autowired
	private IDBI dbi;
	
	private CountryDao countryDao;
    
	public List<CountryRecord> findAll(){
		countryDao = dbi.onDemand(CountryDao.class);
		return countryDao.findAll();
	}

    @Override
    public void remove(CountryRecord user) {
        
    }

    @Override
    public void update(CountryRecord user) {
        
    }


	@Override
	public void add(CountryRecord entity) {
		
	}

}
