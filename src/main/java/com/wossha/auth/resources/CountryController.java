package com.wossha.auth.resources;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wossha.auth.infrastructure.dao.country.CountryRecord;
import com.wossha.auth.infrastructure.repositories.CountryRepository;
import com.wossha.msbase.controllers.ControllerWrapper;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CountryController extends ControllerWrapper{

	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private CountryRepository repo;

	@GetMapping(value = "/countries")
	public @ResponseBody List<CountryRecord> getAllCountries() {
		return repo.findAll();
	}

}
