package com.projetos.abono.model;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Abono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotEmpty(message = "Nome Obrigatório")
	private String nome;

	@NotEmpty(message = "Matrícula Obrigatório")
	@NumberFormat(pattern = "#.##0-0")
	@Size(max = 8, message = "Matrícula não pode conter mais que 6 digítos")
	private String matricula;

	@NotEmpty(message = "Período Obrigatório")
	private String periodo;

	@Enumerated(EnumType.STRING)
	private EscalaAbono escala;

	@NotNull(message = "Dias Obrigatório")
	@NumberFormat
	@DecimalMin(value = "3", message="A quantidade de dias só pode ser 3 ou 5!")
	@DecimalMax(value = "5", message="A quantidade de dias só pode ser 3 ou 5!")
	private Long dias;
	
	@NotEmpty(message = "Data Obrigatória")
	private String dataConsulta; 

	@Enumerated(EnumType.STRING)
	private LotacaoAbono lotacao;
	
	@ManyToOne
	private LancamentoAbono lancamento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public EscalaAbono getEscala() {
		return escala;
	}

	public void setEscala(EscalaAbono escala) {
		this.escala = escala;
	}

	public Long getDias() {
		return dias;
	}

	public void setDias(Long dias) {
		this.dias = dias;
	}

	public LotacaoAbono getLotacao() {
		return lotacao;
	}

	public void setLotacao(LotacaoAbono lotacao) {
		this.lotacao = lotacao;
	}
	
	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Abono other = (Abono) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
