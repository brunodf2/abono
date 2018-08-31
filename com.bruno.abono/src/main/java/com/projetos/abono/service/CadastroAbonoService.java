package com.projetos.abono.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.abono.model.Abono;

import com.projetos.abono.repository.Abonos;


@Service
public class CadastroAbonoService {
	
	@Autowired
	private Abonos abonos;
	
	public void salvar(Abono abono) {
		abonos.save(abono);
	}

	public void excluir(Long codigo) {
		abonos.delete(codigo);
		
		
	}

}



