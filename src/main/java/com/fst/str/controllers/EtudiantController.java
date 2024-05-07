package com.fst.str.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fst.str.entities.Classe;
import com.fst.str.entities.Etudiant;
import com.fst.str.repositories.ClasseRepository;
import com.fst.str.repositories.EtudiantRepository;

@Controller
@RequestMapping("etudiant")
public class EtudiantController {
	EtudiantRepository etudiantRepository;
	ClasseRepository classeRepository;
@Autowired
public EtudiantController(EtudiantRepository etudiantRepository,ClasseRepository classeRepository)
{this.etudiantRepository=etudiantRepository;
this.classeRepository=classeRepository;
	}
	@GetMapping("afficher")
	public String afficher(Model model)
	{
		
		model.addAttribute("etudiants", etudiantRepository.findAll());
		return "afficherE";
	}
	@GetMapping("ajouter")
public String ajouter(	Model model)	
{
		model.addAttribute("classes", classeRepository.findAll());
	return "ajouterE";
		
}
	@PostMapping("ajouter")
	public String add(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("email") String email,@RequestParam("classe")long id)
	{
		Etudiant etudiant = new Etudiant(nom,prenom,email);
		Classe classe = classeRepository.getById(id);
		etudiant.setClasse(classe);
		
		
		etudiantRepository.save(etudiant);
		return "redirect:afficher";
	}
	
	@GetMapping("supprimer/{id}")
	public String supprimer(@PathVariable("id") long id)
	{
		etudiantRepository.deleteById(id);
		return "redirect:../afficher";
		
	}
	@GetMapping("modifier/{id}")
	public String modifier (@PathVariable("id") long id, Model model)
	{
		Etudiant etudiant = etudiantRepository.getById(id);

		
		model.addAttribute("etudiant",etudiant);
		model.addAttribute("classes",classeRepository.findAll());
		
		return "modifier";
	}
	@PostMapping("modifier")
	public String update(Etudiant e)
	{
	
	etudiantRepository.save(e);
		return "redirect:afficher";
		
	}

}
