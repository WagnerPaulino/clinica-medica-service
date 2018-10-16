package com.clinicaMedica.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicaMedica.domain.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

}
