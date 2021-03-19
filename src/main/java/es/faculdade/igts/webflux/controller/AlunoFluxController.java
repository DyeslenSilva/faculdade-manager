package es.faculdade.igts.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.model.Aluno;
import es.faculdade.igts.webflux.repo.AlunoWebFluxRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alunoFluxAPI")
public class AlunoFluxController {

	@Autowired
	private AlunoWebFluxRepo alunoWebFluxRepo;
	
	@PostMapping("/alunos")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Aluno> cadastroAlunos(@PathVariable Aluno aluno){
		return alunoWebFluxRepo.save(aluno);
	}
	
	@GetMapping("/alunos")
	public Flux<Aluno> getAlunos(){
		return alunoWebFluxRepo.findAll();
	}
	
	@GetMapping("/{idAluno}")
	public Mono<Aluno> getAluno(@PathVariable Integer idAluno){
		return alunoWebFluxRepo.findById(idAluno);
	}

	@PutMapping("/aluno/{idAluno}")
	public Mono<Aluno> atualizarAluno(@RequestBody Aluno aluno){
		return alunoWebFluxRepo.updateAluno(aluno);
	}
	
	@DeleteMapping("/aluno/{idAluno}")
	public Mono<Void> deleteAluno(Integer idAluno){
		return alunoWebFluxRepo.deleteById(idAluno);
	}
}