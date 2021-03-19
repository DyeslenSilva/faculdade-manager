package es.faculdade.igts.webflux.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.igts.model.Diretor;
import reactor.core.publisher.Mono;

public interface DiretorWebFluxRepo extends R2dbcRepository<Diretor, Integer> {

	public Mono<Diretor> updateDiretor(Integer idDiretor);
}
