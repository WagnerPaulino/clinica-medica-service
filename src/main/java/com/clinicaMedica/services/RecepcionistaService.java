package com.clinicaMedica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.clinicaMedica.domain.Recepcionista;
import com.clinicaMedica.repositorys.RecepcionistaRepository;

@Service
public class RecepcionistaService {

	@Autowired
	private RecepcionistaRepository repository;

	@Cacheable(value = "recepcionista")
	public List<Recepcionista> findAll() {
		return repository.findAll();
	}

	@Cacheable(value = "recepcionista", key = "#id")
	public Recepcionista findOne(Long id) {
		return repository.findById(id).orElse(new Recepcionista());
	}

	public boolean exists(Long id) {
		return repository.existsById(id);
	}

	@Transactional
	@CacheEvict(value = "recepcionista", allEntries = true)
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElse(new Recepcionista()));
	}

	@Transactional
	@CachePut(value = "recepcionista")
	@CacheEvict(value = "recepcionista", allEntries = true)
	public Recepcionista insert(Recepcionista newRecepcionista) {
		return repository.save(newRecepcionista);
	}

	@Transactional
	@CachePut(value = "recepcionista")
	@CacheEvict(value = "recepcionista", allEntries = true)
	public Recepcionista update(Recepcionista newRecepcionista) {
		return repository.save(newRecepcionista);
	}
}
