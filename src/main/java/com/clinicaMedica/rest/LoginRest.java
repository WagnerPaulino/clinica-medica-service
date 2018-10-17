package com.clinicaMedica.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinicaMedica.domain.Login;
import com.clinicaMedica.services.LoginService;

@RestController
public class LoginRest {

	@Autowired
	private LoginService service;

	@PostMapping("api/login")
	public ResponseEntity<?> sign(@RequestBody Login login) {
		return ResponseEntity.ok().body(this.service.sign(login.getUsuario(), login.getSenha()));
	}
}
