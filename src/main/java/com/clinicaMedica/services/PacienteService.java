package com.clinicaMedica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.clinicaMedica.domain.Paciente;
import com.clinicaMedica.repositorys.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository repository;

	@Cacheable(value = "paciente")
	public List<Paciente> findAll() {
		return repository.findAll();
	}

	public Paciente findOne(Long id) {
		return repository.findById(id).orElse(new Paciente());
	}
	
	public Paciente findPacienteByConsulta(Long id) {
		return this.repository.findPacienteByConsulta(id);
	}

	public boolean exists(Long id) {
		return repository.existsById(id);
	}

	@Transactional
	@CacheEvict(value = "paciente", allEntries = true)
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElse(new Paciente()));
	}

	@Transactional
	@CachePut(value = "paciente")
	@CacheEvict(value = "paciente", allEntries = true)
	public Paciente insert(Paciente newPaciente) {
		return repository.save(newPaciente);
	}

	@Transactional
	@CachePut(value = "paciente")
	@CacheEvict(value = "paciente", allEntries = true)
	public Paciente update(Paciente newPaciente) {
		return repository.save(newPaciente);
	}
}
