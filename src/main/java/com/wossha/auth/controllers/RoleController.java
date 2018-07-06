package com.wossha.auth.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wossha.auth.models.dao.UserDao;
import com.wossha.auth.models.dao.UserRecord;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class RoleController {
	
	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private IDBI dbi;
	
	@RequestMapping(value = "/listar-rest")
	public @ResponseBody String listarRest() {
		
		UserDao userDao = dbi.onDemand(UserDao.class);
		UserRecord user2 = userDao.findByUsername("admin").get(0);
		
		logger.info("Estamos melos: "+user2.getEmail());
		return "Estamos melos";
	}
}
