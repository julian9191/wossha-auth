package com.wossha.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
	
	@GetMapping(value = "/listar-rest")
	public @ResponseBody String listarRest() {
		return "Estamos melos";
	}
}
