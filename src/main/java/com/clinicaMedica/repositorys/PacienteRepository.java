package com.clinicaMedica.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinicaMedica.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	@Query("SELECT p FROM Paciente p INNER JOIN p.consultas")
	public Paciente findPacienteByConsulta(Long id);
}
