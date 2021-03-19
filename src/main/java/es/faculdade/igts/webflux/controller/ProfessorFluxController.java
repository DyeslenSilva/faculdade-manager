package es.faculdade.igts.webflux.controller;

import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.model.Professor;
import es.faculdade.igts.webflux.repo.ProfessorWebFluxRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/apiFluxProfessor")
public class ProfessorFluxController {

	@Autowired 
	private ProfessorWebFluxRepo professorWebFluxRepo;
	
	@PostMapping("/professor")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Professor> cadastroProfessor(@PathVariable Professor prof){
		return professorWebFluxRepo.save(prof);
	}
	
	@GetMapping("/professores")
	public Flux<Professor> getProfessores(){
		return professorWebFluxRepo.findAll();
	}
	
	@GetMapping("/professor/{idProfessor}")
	public Mono<Professor> getProfessor(@PathVariable Integer idProfessor){
		return professorWebFluxRepo.findById(idProfessor);
	}
}
