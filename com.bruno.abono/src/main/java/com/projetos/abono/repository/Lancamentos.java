package com.projetos.abono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.abono.model.LancamentoAbono;

public interface Lancamentos extends JpaRepository<LancamentoAbono, String> {

}
