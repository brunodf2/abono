package com.projetos.abono.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.abono.model.Abono;

public interface Abonos extends JpaRepository<Abono, Long > {
	
	public List<Abono> findByNomeContaining(String nome);

}
