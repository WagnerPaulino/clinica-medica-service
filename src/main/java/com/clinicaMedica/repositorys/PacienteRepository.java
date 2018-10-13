package com.clinicaMedica.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicaMedica.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
