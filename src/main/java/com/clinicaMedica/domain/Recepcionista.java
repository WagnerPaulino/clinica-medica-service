package com.clinicaMedica.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "recepcionista")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Recepcionista extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Boolean adm;
	@Column
	private String cfpExistente;
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonBackReference(value = "pacientes")
	private List<Paciente> pacientes;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value = "proprietario")
	private Proprietario proprietario;
	@OneToMany(mappedBy = "recepcionistas",cascade = CascadeType.ALL)
	private List<Consulta> consultas;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	public Recepcionista() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAdm() {
		return adm;
	}

	public void setAdm(Boolean adm) {
		this.adm = adm;
	}

	public String getCfpExistente() {
		return cfpExistente;
	}

	public void setCfpExistente(String cfpExistente) {
		this.cfpExistente = cfpExistente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cfpExistente == null) ? 0 : cfpExistente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recepcionista other = (Recepcionista) obj;
		if (cfpExistente == null) {
			if (other.cfpExistente != null)
				return false;
		} else if (!cfpExistente.equals(other.cfpExistente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}