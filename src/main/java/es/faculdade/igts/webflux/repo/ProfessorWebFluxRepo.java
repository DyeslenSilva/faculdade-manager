package es.faculdade.igts.webflux.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.igts.model.Professor;

public interface ProfessorWebFluxRepo extends R2dbcRepository<Professor, Integer> {

}
