package com.projetos.abono.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class LancamentoAbono {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String matricula2;
	
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String periodo;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Long dia1;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Long dia2;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Long dia3;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Long dia4;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Long dia5;
	
	@OneToOne
	private Abono abono;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricula2() {
		return matricula2;
	}
	public void setMatricula2(String matricula2) {
		this.matricula2 = matricula2;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Long getDia1() {
		return dia1;
	}
	public void setDia1(Long dia1) {
		this.dia1 = dia1;
	}
	public Long getDia2() {
		return dia2;
	}
	public void setDia2(Long dia2) {
		this.dia2 = dia2;
	}
	public Long getDia3() {
		return dia3;
	}
	public void setDia3(Long dia3) {
		this.dia3 = dia3;
	}
	public Long getDia4() {
		return dia4;
	}
	public void setDia4(Long dia4) {
		this.dia4 = dia4;
	}
	public Long getDia5() {
		return dia5;
	}
	public void setDia5(Long dia5) {
		this.dia5 = dia5;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		LancamentoAbono other = (LancamentoAbono) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	


}
