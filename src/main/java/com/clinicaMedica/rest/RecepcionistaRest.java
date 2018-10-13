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

import com.clinicaMedica.domain.Recepcionista;
import com.clinicaMedica.services.RecepcionistaService;

@RestController
@CrossOrigin
public class RecepcionistaRest {
private Logger log = LoggerFactory.getLogger(Recepcionista.class);
	
	@Autowired
	private RecepcionistaService service;
	
	@GetMapping(path = "/api/recepcionistas")
	public ResponseEntity<?> findAll() {
		log.debug("[findAll] Requisição para buscar todos recepcionistas");
		List<Recepcionista> recepcionistas = service.findAll();
		log.debug("=========" + recepcionistas);
		return ResponseEntity.ok().body(recepcionistas);

	}

	@GetMapping(path = "/api/recepcionistas/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar Recepcionista. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[find] Recepcionista encontrado.");
			return ResponseEntity.ok(service.findOne(id));
		}
		log.debug("[find] Recepcionista NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = "/api/recepcionistas/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar Recepcionista. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[delete] Recepcionista encontrado.");
			service.delete(id);
			log.debug("[delete] Recepcionista deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] Recepcionista NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/api/recepcionistas")
	public ResponseEntity<?> insert(@Valid @RequestBody Recepcionista recepcionista) {
		log.debug("[insert] Requisição para inserir Recepcionista...");
		Recepcionista insertedRecepcionista = service.insert(recepcionista);
		log.debug("[insert] Recepcionista inserido com sucesso. id={}", insertedRecepcionista.getId());
		return ResponseEntity.ok(insertedRecepcionista);
	}

	@PutMapping(path = "/api/recepcionistas/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody Recepcionista recepcionista) {
		log.debug("[update] Requisição para atualizar de Recepcionista...");
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[update] Recepcionista encontrado.");
			Recepcionista updatedRecepcionista = service.update(recepcionista);
			log.debug("[update] Recepcionista atualizado com sucesso.");
			return ResponseEntity.ok(updatedRecepcionista);
		}
		log.debug("[update] Recepcionista NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}
