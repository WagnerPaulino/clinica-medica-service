package com.clinicaMedica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "consulta")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Consulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String especialidade;
	@Column
	private String diagnostico;
	@Column
	private String exame;
	@Column
	private String tratamento;
	@Column
	private String sintomas;
	@Column
	private String descricao;
	@Column
	private Double peso;
	@Column
	private Double altura;
	@Column
	private Integer pressao;
	@Column
	private String dtConsulta;
	@Column
	private String dtRetorno;
	@Column
	private Boolean realizada;
	@Column
	private Double valorConsulta;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value = "recepcionistas")
	private Recepcionista recepcionistas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value = "medico")
	private Medico medico;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value = "paciente")
	private Paciente paciente;

	public Consulta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getTratamento() {
		return tratamento;
	}

	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getPressao() {
		return pressao;
	}

	public void setPressao(Integer pressao) {
		this.pressao = pressao;
	}

	public String getDtConsulta() {
		return dtConsulta;
	}

	public void setDtConsulta(String dtConsulta) {
		this.dtConsulta = dtConsulta;
	}

	public String getDtRetorno() {
		return dtRetorno;
	}

	public void setDtRetorno(String dtRetorno) {
		this.dtRetorno = dtRetorno;
	}

	public Double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Recepcionista getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(Recepcionista recepcionistas) {
		this.recepcionistas = recepcionistas;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((pressao == null) ? 0 : pressao.hashCode());
		result = prime * result + ((valorConsulta == null) ? 0 : valorConsulta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (pressao == null) {
			if (other.pressao != null)
				return false;
		} else if (!pressao.equals(other.pressao))
			return false;
		if (valorConsulta == null) {
			if (other.valorConsulta != null)
				return false;
		} else if (!valorConsulta.equals(other.valorConsulta))
			return false;
		return true;
	}

}