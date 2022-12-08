package com.rhempresax.rhempresax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rhempresax.rhempresax.entity.Empregado;
import com.rhempresax.rhempresax.repository.IEmpregadoRepository;

@Controller
public class EmpregadoController {
	
	@Autowired
	private IEmpregadoRepository eRepo;
	
	@GetMapping({"/mostrarEmpregados", "/", "/list"})
	public ModelAndView mostrarEmpregados() {
		ModelAndView mav = new ModelAndView("lista-empregados");
		List<Empregado> list =  eRepo.findAll();
		mav.addObject("empregados", list);
		return mav;
	}
	
	@GetMapping("/addEmpregadoForm")
	public ModelAndView addEmpregadoForm() {
		ModelAndView mav = new ModelAndView("add-empregado-form");
		Empregado novoEmpregado = new Empregado();
		mav.addObject("empregado", novoEmpregado);
		return mav;
	}
	
	@PostMapping("/salvarEmpregado")
	public String salvarEmpregado(@ModelAttribute Empregado empregado) {
		eRepo.save(empregado);
		return "redirect:/list";
	}
	
	@GetMapping("/mostrarEdicoesForm")
	public ModelAndView mostrarEdicoesForm(@RequestParam Long empregadoId) {
		ModelAndView mav = new ModelAndView("add-empregado-form");
		Empregado empregado = eRepo.findById(empregadoId).get();
		mav.addObject("empregado", empregado);
		return mav;
	}
	
	@GetMapping("/apagarEmpregado")
	public String apagarEmpregado(@RequestParam Long empregadoId) {
		eRepo.deleteById(empregadoId);
		return "redirect:/list";
	}
}
