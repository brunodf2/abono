package com.projetos.abono.model;

public enum EscalaAbono {
	
	DIARIA("Diária"),
	PLANTAO("Plantão");
	
	
	private String escala;
	
	EscalaAbono(String escala) {
		this.escala = escala;
		
	}
	
	public String getDescricao() {
		return escala;
	}

}
