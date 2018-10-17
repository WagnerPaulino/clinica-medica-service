package com.clinicaMedica.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinicaMedica.domain.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

	@Query("select l from Login l where l.usuario like ?1 and l.senha like ?2")
	public Login sign(String login, String senha);
	
}
