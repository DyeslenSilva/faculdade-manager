package es.faculdade.igts.webflux.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.igts.model.Aluno;
import es.faculdade.igts.model.Coordenador;
import reactor.core.publisher.Mono;

public interface CoordenadorWebFluxRepo extends R2dbcRepository<Coordenador, Integer> {

	public Mono<Coordenador> updateCoordenador(Coordenador coordenador);

	public Mono<Coordenador> save(Integer idCoordenador);

	public Mono<Coordenador> updateCoordenador(Integer idCoordenador);

}
