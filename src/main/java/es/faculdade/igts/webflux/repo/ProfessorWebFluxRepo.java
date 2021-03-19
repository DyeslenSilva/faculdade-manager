package es.faculdade.igts.webflux.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.web.bind.annotation.PathVariable;

import es.faculdade.igts.model.Professor;
import reactor.core.publisher.Mono;

public interface ProfessorWebFluxRepo extends R2dbcRepository<Professor, Integer> {

	
	
	public Mono<Professor> updateProfessor( Integer idProfessor);
		
	
}
