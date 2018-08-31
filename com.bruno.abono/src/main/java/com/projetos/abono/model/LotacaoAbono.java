package com.projetos.abono.model;

public enum LotacaoAbono {

	PANC("PANC"), PANCA("PANCA"), PANCE("PANCE");

	private String lotacao;

	LotacaoAbono(String lotacao) {
		this.lotacao = lotacao;

	}

	public String getDescricao() {
		return lotacao;
	}

}
