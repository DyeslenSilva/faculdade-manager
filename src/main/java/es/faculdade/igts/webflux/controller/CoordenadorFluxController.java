package es.faculdade.igts.webflux.controller;

import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.model.Coordenador;
import es.faculdade.igts.webflux.repo.CoordenadorWebFluxRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coordenadorFluxAPI")
public class CoordenadorFluxController {

	@Autowired
	private CoordenadorWebFluxRepo coordenadorWebFluxRepo;
	
	@PostMapping("/coodenador")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<Coordenador> cadastroCoordenador(@PathVariable Coordenador coordenador){
		return coordenadorWebFluxRepo.save(coordenador);
	}
	
	@GetMapping("/coordenadores")
	public Flux<Coordenador> getCoordenadores(){
		return coordenadorWebFluxRepo.findAll();
	}
	
	@GetMapping("/coodenador/{idCoordenador}")
	public Mono<Coordenador> getCoordenador(@PathVariable Integer idCoordenador){
		return coordenadorWebFluxRepo.findById(idCoordenador);
	}
	
	@PutMapping("/coordenador/{idCoordenador}")
	public Mono<Coordenador> updateCoordenador(@PathVariable Integer idCoordenador){
		return coordenadorWebFluxRepo.updateCoordenador(idCoordenador);
	}
	
	@DeleteMapping("/coordenador/{idCoordenador}")
	public Mono<Void> deleteCoordenador(@PathVariable Integer idCoordenador){
		return coordenadorWebFluxRepo.deleteById(idCoordenador);
	}
	
	
}
