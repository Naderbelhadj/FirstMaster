package com.fst.str.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fst.str.entities.Classe;
import com.fst.str.repositories.ClasseRepository;
@Controller
@RequestMapping("classe")
public class ClasseController {
	@Autowired
	ClasseRepository classeRepository;
	@GetMapping("afficher")
	//@ResponseBody
	public String afficher(Model model)
	{
		//Classe classe1=new Classe("MPSRT");
		//Classe classe2=new Classe("Physique");
		//classeRepository.save(classe1);
		//classeRepository.save(classe2);
			//model.addAttribute("classes", classeRepository.findAll());
		//List<Classe> classes=(List<Classe>) classeRepository.findAll();
		model.addAttribute("classes", classeRepository.findAll());
		return "afficher";
		
	}
		@GetMapping("add")
		public String ajouter()
		{
			return "ajouter";
			
		}
		@PostMapping("add")
		public String ajoutClasse(@RequestParam("nom") String nom)
		{
			Classe classe=new Classe(nom);
			
			classeRepository.save(classe);
			return "redirect:afficher";
		
		}
		@GetMapping("delete/{id}")
		public String supprimer(@PathVariable("id") long id)
		
		{
			classeRepository.deleteById(id);
			
			return "redirect:../afficher";
			
			
		}
		
		
}
