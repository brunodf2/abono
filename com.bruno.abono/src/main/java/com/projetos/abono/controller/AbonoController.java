package com.projetos.abono.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetos.abono.model.Abono;
import com.projetos.abono.model.EscalaAbono;
import com.projetos.abono.model.LancamentoAbono;
import com.projetos.abono.model.LotacaoAbono;
import com.projetos.abono.repository.AbonoFilter;
import com.projetos.abono.repository.Abonos;
import com.projetos.abono.repository.Lancamentos;
import com.projetos.abono.service.CadastroAbonoService;



@Controller

@RequestMapping("/abono")
public class AbonoController {
	
	private static final String  CADASTRO_VIEW = "CadastroAbono"; 


	@Autowired
	private Abonos abonos;
	
	@Autowired
	private Lancamentos lancamentos;
	
	
	@Autowired
	private CadastroAbonoService cadastroAbonoService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Abono());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Abono abono, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors())  {
			return "CadastroAbono";
		}
	
		try {
			cadastroAbonoService.salvar(abono);
			attributes.addFlashAttribute("mensagem", "Abono salvo com sucesso!");
			return "redirect:/abono/novo";
		} catch (NumberFormatException e) {
			errors.rejectValue("dias", null, "Campo so deve incluir número");
			return CADASTRO_VIEW;
		}	
		
		
	}

	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") AbonoFilter filtro) {
		
		
		String nome = filtro.getNome() == null ? "%" : filtro.getNome(); 
		List<Abono> todosAbonos = abonos.findByNomeContaining(nome);
		
		
		ModelAndView mv = new ModelAndView("PesquisaAbono");
		mv.addObject("abonos", todosAbonos);
		return mv;
		
		
		

	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Abono abono) {
		
		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(abono);
		return mv;
		
		
	}
	
	@RequestMapping(value="/lancados", method= RequestMethod.GET)
	public ModelAndView lancamentoAbono( ) {
		ModelAndView mv = new ModelAndView("LancamentoAbono");
		mv.addObject(lancamentos);
		return mv;
		
		
	}
	
	
	
	
	@RequestMapping(value="/lancados", method=RequestMethod.POST)
	public String lancamentoAbono(@Validated LancamentoAbono lancamentoAbono, Errors errors, RedirectAttributes attributes) {
		ModelAndView mv= new ModelAndView();
		mv.addObject(lancamentos);
		if (errors.hasErrors()) {
			return "redirect:/abono/lancados";
		}
		lancamentos.save(lancamentoAbono);
		attributes.addFlashAttribute("mensagem", "Abono lançado com sucesso!");
		
		return "redirect:/abono/lancados";
		
		
	}
	
			
			

	@ModelAttribute
	public List<EscalaAbono> todosEscalasAbono() {
		return Arrays.asList(EscalaAbono.values());
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes ) {
		cadastroAbonoService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Abono excluido com sucesso!");
		return "redirect:/abono";
		
	}
	
	
		
	
	
	@ModelAttribute("todosLotacaoAbono")
	public List<LotacaoAbono> todosLotacaoAbono() {
		return Arrays.asList(LotacaoAbono.values());
	}
	
	
	
	
	
	
}