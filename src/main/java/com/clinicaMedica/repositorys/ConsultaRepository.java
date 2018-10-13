package com.clinicaMedica.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicaMedica.domain.Consulta;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
