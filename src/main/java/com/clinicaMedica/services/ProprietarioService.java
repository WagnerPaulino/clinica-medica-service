package com.clinicaMedica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.clinicaMedica.domain.Proprietario;
import com.clinicaMedica.repositorys.ProprietarioRepository;

@Service
public class ProprietarioService {
	@Autowired
	private ProprietarioRepository repository;

	@Cacheable(value = "proprietario")
	public List<Proprietario> findAll() {
		return repository.findAll();
	}

	public Proprietario findOne(Long id) {
		return repository.findById(id).orElse(new Proprietario());
	}

	public boolean exists(Long id) {
		return repository.existsById(id);
	}

	@Transactional
	@CacheEvict(value = "proprietario", allEntries = true)
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElse(new Proprietario()));
	}

	@Transactional
	@CachePut(value = "proprietario")
	@CacheEvict(value = "proprietario", allEntries = true)
	public Proprietario insert(Proprietario newProprietario) {
		return repository.save(newProprietario);
	}

	@Transactional
	@CachePut(value = "proprietario")
	@CacheEvict(value = "proprietario", allEntries = true)
	public Proprietario update(Proprietario newProprietario) {
		return repository.save(newProprietario);
	}
}
