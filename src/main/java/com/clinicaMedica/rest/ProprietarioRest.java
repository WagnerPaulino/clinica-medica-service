package com.clinicaMedica.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinicaMedica.domain.Proprietario;
import com.clinicaMedica.services.ProprietarioService;

@RestController
@CrossOrigin
public class ProprietarioRest {
private Logger log = LoggerFactory.getLogger(Proprietario.class);
	
	@Autowired
	private ProprietarioService service;
	
	@GetMapping(path = "/api/proprietarios")
	public ResponseEntity<?> findAll() {
		log.debug("[findAll] Requisição para buscar todos proprietarios");
		List<Proprietario> proprietarios = service.findAll();
		log.debug("=========" + proprietarios);
		return ResponseEntity.ok().body(proprietarios);

	}

	@GetMapping(path = "/api/proprietarios/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar Proprietario. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[find] Proprietario encontrado.");
			return ResponseEntity.ok(service.findOne(id));
		}
		log.debug("[find] Proprietario NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = "/api/proprietarios/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar Proprietario. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[delete] Proprietario encontrado.");
			service.delete(id);
			log.debug("[delete] Proprietario deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] Proprietario NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/api/proprietarios")
	public ResponseEntity<?> insert(@Valid @RequestBody Proprietario proprietario) {
		log.debug("[insert] Requisição para inserir Proprietario...");
		Proprietario insertedProprietario = service.insert(proprietario);
		log.debug("[insert] Proprietario inserido com sucesso. id={}", insertedProprietario.getId());
		return ResponseEntity.ok(insertedProprietario);
	}

	@PutMapping(path = "/api/proprietarios/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody Proprietario proprietario) {
		log.debug("[update] Requisição para atualizar de Proprietario...");
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[update] Proprietario encontrado.");
			Proprietario updatedProprietario = service.update(proprietario);
			log.debug("[update] Proprietario atualizado com sucesso.");
			return ResponseEntity.ok(updatedProprietario);
		}
		log.debug("[update] Proprietario NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}
