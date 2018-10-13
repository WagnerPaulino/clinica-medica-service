package com.clinicaMedica.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinicaMedica.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
	
	@Query("SELECT m FROM Medico m JOIN m.consultas")
	public Medico findMedicoByConsulta(Long id);
}
