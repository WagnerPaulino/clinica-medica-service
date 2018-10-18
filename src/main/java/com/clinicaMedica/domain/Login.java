package com.clinicaMedica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "login")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String usuario;

	@Column(nullable = false, unique = true)
	private String senha;

	@OneToOne(mappedBy = "login")
	private Medico medico;

	@OneToOne(mappedBy = "login")
	private Paciente paciente;

	@OneToOne(mappedBy = "login")
	private Proprietario proprietario;

	@OneToOne(mappedBy = "login")
	private Recepcionista recepcionista;

	public Login() {
		super();
	}

	public Login(Long id, String usuario, String senha, Medico medico, Paciente paciente, Proprietario proprietario,
			Recepcionista recepcionista) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.medico = medico;
		this.paciente = paciente;
		this.proprietario = proprietario;
		this.recepcionista = recepcionista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Recepcionista getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", medico=" + medico + ", paciente="
				+ paciente + ", proprietario=" + proprietario + ", recepcionista=" + recepcionista + "]";
	}

}
