package com.wossha.auth.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.wossha.auth.infrastructure.filters.UsernameInfoAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wossha.auth.dto.ChatUserStatus;
import com.wossha.auth.dto.UserSearchDTO;
import com.wossha.auth.infrastructure.dao.user.UserRecord;
import com.wossha.auth.infrastructure.repositories.UserRepository;
import com.wossha.auth.infrastructure.services.model.UserSessionInfo;
import com.wossha.msbase.controllers.ControllerWrapper;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/users")
public class UserController extends ControllerWrapper{
	
	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserRepository repo;
	
	@PostMapping(value = "/register-user")
	public @ResponseBody ResponseEntity<HashMap<String, String>> registerUser(@RequestBody UserRecord user) {
		user.setUsername(user.getUsername().toLowerCase());
		user.setEmail(user.getEmail().toLowerCase());
		try {
			UserRecord RegisteredUser = repo.findUserByUsernameOrEmail(user.getUsername(), user.getEmail());
			
			if(RegisteredUser != null) {
				if(RegisteredUser.getUsername().equals(user.getUsername())) {
					return new ResponseEntity<HashMap<String, String>>(super.wrapMessaje("El nombre de usuario "+user.getUsername()+" ya está siendo utilizado por otra cuenta, por favor intente con uno diferente"),HttpStatus.INTERNAL_SERVER_ERROR);
				}
				if(RegisteredUser.getEmail().equals(user.getEmail())) {
					return new ResponseEntity<HashMap<String, String>>(wrapMessaje("El email "+user.getEmail()+" ya está siendo utilizado por otra cuenta, por favor intente con uno diferente"),HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			if(RegisteredUser==null) {
				repo.addUser(user);
				return new ResponseEntity<HashMap<String, String>>(wrapMessaje("El usuario se ha registrado correctamente, ahora puede iniciar sesión"),HttpStatus.OK);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<HashMap<String, String>>(wrapMessaje("Ha ocurrido un error al intentar registrar el usuario"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/search-user/{word}")
	public @ResponseBody List<UserSearchDTO> searchUser(@PathVariable String word) {
		List<UserSearchDTO> c = repo.searchUser(word);
		return c;
	}
	
	@GetMapping(value = "/{username}")
	public @ResponseBody UserRecord getUserByUsername(@PathVariable String username) {
		UserRecord t = repo.findUserByUsername(username);
		return t;
	}
	
	@GetMapping(value = "/logged-user-info")
	public @ResponseBody UserSessionInfo getLoggedUserInfo() {
		
		UsernameInfoAuthenticationToken auth = (UsernameInfoAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();
		
		UserRecord user = repo.findCompleteByUsername(username);
		
		UserSessionInfo userSesionInfo = null;
        try {
        	userSesionInfo = new UserSessionInfo(URLEncoder.encode(user.getFirstName(), "UTF-8"), URLEncoder.encode(user.getLastName(), "UTF-8"), user.getProfilePicture());
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
		return userSesionInfo;
	}
	
	@PostMapping(value = "/chat-friends")
	public @ResponseBody List<ChatUserStatus> getChatFriends(@RequestBody List<String> usernames) {
		System.out.println(usernames.toString());
		
		List<ChatUserStatus> c = repo.getChatFriendsStatus(usernames); 
		return c;
	}
	
}
