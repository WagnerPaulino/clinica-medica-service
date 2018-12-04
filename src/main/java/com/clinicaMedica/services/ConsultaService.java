package com.clinicaMedica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.clinicaMedica.domain.Consulta;
import com.clinicaMedica.projections.CountConsultaProximosDias;
import com.clinicaMedica.repositorys.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	@Cacheable(value = "consulta")
	public List<Consulta> findAll() {
		return repository.findAll();
	}

	@Cacheable(value = "consulta", key = "#id")
	@Transactional
	public Consulta findOne(Long id) {
		return repository.findById(id).orElse(new Consulta());
	}
	
	@Transactional
	public Consulta findProntuario(Long id) {
		Consulta consulta = repository.findById(id).orElse(new Consulta());
		Hibernate.initialize(consulta);
		return consulta; 
	}

	public boolean exists(Long id) {
		return repository.existsById(id);
	}

	@Cacheable(value = "countConsultasProximosDias")
	public List<CountConsultaProximosDias> countConsultasProximosDias() {
		return this.repository.countConsultasProximosDias();
	}

	@Transactional
	@Caching(evict = { @CacheEvict(value = "consulta", allEntries = true),
			@CacheEvict(value = "pacienteConsulta", allEntries = true),
			@CacheEvict(value = "medicoConsulta", allEntries = true),
			@CacheEvict(value = "countConsultasProximosDias", allEntries = true) })
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElse(new Consulta()));
	}

	@Transactional
	@CachePut(value = "consulta")
	@Caching(evict = { @CacheEvict(value = "consulta", allEntries = true),
			@CacheEvict(value = "pacienteConsulta", allEntries = true),
			@CacheEvict(value = "medicoConsulta", allEntries = true),
			@CacheEvict(value = "countConsultasProximosDias", allEntries = true) })
	public Consulta insert(Consulta newConsulta) {
		return repository.save(newConsulta);
	}

	@Transactional
	@CachePut(value = "consulta")
	@Caching(evict = { @CacheEvict(value = "consulta", allEntries = true),
			@CacheEvict(value = "pacienteConsulta", allEntries = true),
			@CacheEvict(value = "medicoConsulta", allEntries = true),
			@CacheEvict(value = "countConsultasProximosDias", allEntries = true) })
	public Consulta update(Consulta newConsulta) {
		return repository.save(newConsulta);
	}
}
