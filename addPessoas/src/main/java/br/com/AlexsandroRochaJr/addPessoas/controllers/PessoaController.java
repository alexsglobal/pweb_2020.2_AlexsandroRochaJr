package br.com.AlexsandroRochaJr.addPessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AlexsandroRochaJr.addPessoas.model.Pessoa;
import br.com.AlexsandroRochaJr.addPessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepo;
	
	
	
	@GetMapping("/")
	public String indexx () {
	 return "index.html";
	}
	
	@GetMapping("/index.html")
	public String index () {
	 return "index.html";
}
	//as 2 formas possíveis de ser acessado o menu "listar pessoas"
	@GetMapping("/listarPessoas")
	public ModelAndView listarPessoas () {
		List<Pessoa> lista = pessoaRepo.findAll();
	ModelAndView mav = new ModelAndView("listarPessoas");
	mav.addObject("pessoas", lista);
	return mav;
	}
	@GetMapping("/listarPessoas.html")
	public ModelAndView listarPessoascomhtml () {
		List<Pessoa> lista = pessoaRepo.findAll();
	ModelAndView mav = new ModelAndView("listarPessoas");
	mav.addObject("pessoas", lista);
	return mav;
	}
	@GetMapping("/addPessoas.html")
	public String addPessoas () {
	 return "addPessoas.html";
	}
	
	
	}
	
	
