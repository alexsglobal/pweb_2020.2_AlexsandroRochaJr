package br.com.AlexsandroRochaJr.addPessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/addPessoas")
	public ModelAndView formAddPessoas() {
		ModelAndView modelAndView = new ModelAndView("addPessoas");
		modelAndView.addObject(new Pessoa());
		return modelAndView;
	}
	
	@PostMapping("/addPessoas")
	public String addPessoas(Pessoa aSalvar) {
	this.pessoaRepo.save(aSalvar);
	return "redirect:/listarPessoas";
	}
		@GetMapping("/editar/{id}")
		public ModelAndView formEditar(@PathVariable("id")long id) {
			Pessoa aEditar = pessoaRepo.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("ID inválido:"+ id));
			
			ModelAndView modelAndView = new ModelAndView("editar");
			modelAndView.addObject(aEditar);
			return modelAndView;
			}
	@PostMapping("/editar/{id}")
	public ModelAndView editarPessoa(@PathVariable("id")long id, Pessoa pessoa) {
	pessoaRepo.save(pessoa);
	return new ModelAndView("redirect:/listarPessoas");
	}
	
@GetMapping("/remover/{id}")
public ModelAndView removerPessoa(@PathVariable("id")long id) {
	Pessoa aRemover = pessoaRepo.findById(id)
	.orElseThrow(()	-> new IllegalArgumentException("ID inválido:" + id ));
	
	pessoaRepo.delete(aRemover);
	return new ModelAndView("redirect:/listarPessoas");
	}
}
	
