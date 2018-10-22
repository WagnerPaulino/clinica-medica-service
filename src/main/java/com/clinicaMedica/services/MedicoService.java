package com.clinicaMedica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.clinicaMedica.domain.Medico;
import com.clinicaMedica.repositorys.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	private MedicoRepository repository;

	@Cacheable(value = "medico")
	public List<Medico> findAll() {
		return repository.findAll();
	}

	public Medico findOne(Long id) {
		return repository.findById(id).orElse(new Medico());
	}
	
	@Cacheable(value = "medicoConsulta")
	public Medico findMedicoByConsulta(Long idConsulta) {
		return this.repository.findMedicoByConsulta(idConsulta);
	}

	public boolean exists(Long id) {
		return repository.existsById(id);
	}

	@Transactional
	@Caching(evict = {
			@CacheEvict(value = "medico", allEntries = true),
			@CacheEvict(value = "medicoConsulta", allEntries = true)		  
		})
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElse(new Medico()));
	}

	@Transactional
	@CachePut(value = "medico")
	@Caching(evict = {
			@CacheEvict(value = "medico", allEntries = true),
			@CacheEvict(value = "medicoConsulta", allEntries = true)		  
		})
	public Medico insert(Medico newMedico) {
		return repository.save(newMedico);
	}

	@Transactional
	@CachePut(value = "medico")
	@Caching(evict = { @CacheEvict(value = "medico", allEntries = true),
			@CacheEvict(value = "medicoConsulta", allEntries = true) })
	public Medico update(Medico newMedico) {
		return repository.save(newMedico);
	}
}
