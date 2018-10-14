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

import com.clinicaMedica.domain.Paciente;
import com.clinicaMedica.services.PacienteService;

@RestController
@CrossOrigin
public class PacienteRest {
private Logger log = LoggerFactory.getLogger(Paciente.class);
	
	@Autowired
	private PacienteService service;
	
	@GetMapping(path = "/api/pacientes")
	public ResponseEntity<?> findAll() {
		log.debug("[findAll] Requisição para buscar todos pacientes");
		List<Paciente> pacientes = service.findAll();
		log.debug("=========" + pacientes);
		return ResponseEntity.ok().body(pacientes);

	}

	@GetMapping(path = "/api/pacientes/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar Paciente. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[find] Paciente encontrado.");
			return ResponseEntity.ok(service.findOne(id));
		}
		log.debug("[find] Paciente NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/api/pacientes/consulta/{id}")
	public ResponseEntity<?> findPacienteByConsulta(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.findPacienteByConsulta(id));
	}

	@DeleteMapping(path = "/api/pacientes/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar Paciente. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[delete] Paciente encontrado.");
			service.delete(id);
			log.debug("[delete] Paciente deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] Paciente NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/api/pacientes")
	public ResponseEntity<?> insert(@Valid @RequestBody Paciente paciente) {
		log.debug("[insert] Requisição para inserir Paciente...");
		Paciente insertedPaciente = service.insert(paciente);
		log.debug("[insert] Paciente inserido com sucesso. id={}", insertedPaciente.getIdPaciente());
		return ResponseEntity.ok(insertedPaciente);
	}

	@PutMapping(path = "/api/pacientes/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody Paciente paciente) {
		log.debug("[update] Requisição para atualizar de Paciente...");
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[update] Paciente encontrado.");
			Paciente updatedPaciente = service.update(paciente);
			log.debug("[update] Paciente atualizado com sucesso.");
			return ResponseEntity.ok(updatedPaciente);
		}
		log.debug("[update] Paciente NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}
