package com.wossha.auth.controllers;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wossha.auth.models.dao.UserDao;
import com.wossha.auth.models.dao.UserRecord;
import com.wossha.auth.models.repository.UserRepository;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class UserController {
	
	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserRepository repo;
	
		@PostMapping(value = "/register-user")
		public @ResponseBody ResponseEntity<HashMap<String, String>> registerUser(@RequestBody UserRecord user) {
			try {
				UserRecord RegistereddUser = repo.findUserByUsername(user.getUsername());
				if(RegistereddUser==null) {
					repo.addUser(user);
					return new ResponseEntity<HashMap<String, String>>(wrapMessaje("El usuario se ha registrado correctamente"),HttpStatus.OK);
				}
				return new ResponseEntity<HashMap<String, String>>(wrapMessaje("El nombre de usuario "+user.getUsername()+" ya está siendo utilizado por otra cuenta, por favor intente con uno diferente"),HttpStatus.INTERNAL_SERVER_ERROR);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<HashMap<String, String>>(wrapMessaje("Ha ocurrido un error al intentar registrar el usuario"),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
			
		private HashMap<String, String> wrapMessaje(String msj) {
	        HashMap<String, String> map = new HashMap<>();
	        map.put("msj", msj);
	        return map;
	    }
		
}