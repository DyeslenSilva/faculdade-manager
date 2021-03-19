package es.faculdade.igts.webflux.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.igts.model.Aluno;
import reactor.core.publisher.Mono;

public interface AlunoWebFluxRepo extends R2dbcRepository<Aluno, Integer> {

	public Mono<Aluno> updateAluno(Aluno aluno);
}
