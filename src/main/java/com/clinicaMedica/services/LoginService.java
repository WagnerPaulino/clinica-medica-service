package com.clinicaMedica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicaMedica.domain.Login;
import com.clinicaMedica.repositorys.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	public Login sign(String login, String senha) {
		return this.repository.sign(login, senha);
	}
	
	public void save(Login login) {
		this.repository.save(login);
	}
}
