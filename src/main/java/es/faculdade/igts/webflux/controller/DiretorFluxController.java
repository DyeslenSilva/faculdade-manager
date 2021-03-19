package es.faculdade.igts.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.model.Diretor;
import es.faculdade.igts.webflux.repo.DiretorWebFluxRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/diretorFluxApi")
public class DiretorFluxController {

	@Autowired
	private DiretorWebFluxRepo diretorWebFluxRepo;
	
	@PostMapping("/diretor")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public Mono<Diretor> cadastroDiretor(@PathVariable Diretor diretor){
		return diretorWebFluxRepo.save(diretor);
	}
	
	@GetMapping("/diretores")
	public Flux<Diretor> getDiretores(){
		return diretorWebFluxRepo.findAll();
	}
	
	@GetMapping("/diretor/{idDiretor}")
	public Mono<Diretor> getDiretor(@PathVariable Integer idDiretor){
		return diretorWebFluxRepo.findById(idDiretor);
	}
	
	@PutMapping("/updateDiretor/{idDiretor}")
	public Mono<Diretor> updateDiretor(@PathVariable Integer idDiretor){
		return diretorWebFluxRepo.updateDiretor(idDiretor);
	}
	
	public Mono<Void> deleteDiretor(@PathVariable Integer idDiretor){
		return diretorWebFluxRepo.deleteById(idDiretor);
	}
}
