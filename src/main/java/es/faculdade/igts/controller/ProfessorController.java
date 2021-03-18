package es.faculdade.igts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.model.Professor;
import es.faculdade.igts.service.ProfessorService;

@RestController
@RequestMapping("/professorAPI")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping("/cadastroProfessor")
	public ResponseEntity<Professor> cadastroProfessor(@PathVariable Professor professor){
		professorService.salvaProfessor(professor);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/professor/{idProfessor}")
	public ResponseEntity<Professor> getProfessor(@PathVariable Integer idProfessor){
		professorService.getProfessor(idProfessor);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/professores")
	public ResponseEntity<List<Professor>> getProfessores(){
		return ResponseEntity.ok(professorService.getProfessores());
	}
	
	@RequestMapping("/editarProfessor/{idProfessor}")
	public ResponseEntity<Professor> editaProfessor(@PathVariable Integer idProfessor){
		Professor professor = professorService.getProfessor(idProfessor);
		if(professor!=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteProfessor/{idProfessor}")
	public ResponseEntity<Professor> deleteProfessor(@PathVariable Integer [] idProfessor){
		professorService.removeProfessor(idProfessor);
		return ResponseEntity.ok().build();
	}

}
